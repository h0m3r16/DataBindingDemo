package com.databinding.notes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.databinding.notes.R;
import com.databinding.notes.adapter.NoteAdapter;
import com.databinding.notes.model.Note;

import java.util.ArrayList;

public class NoteListActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_CREATE = 1;

    private NoteAdapter mNoteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.activity_note_list_fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(NoteListActivity.this,
                        CreateNoteActivity.class), REQUEST_CODE_CREATE);
            }
        });

        RecyclerView list = (RecyclerView) findViewById(R.id.activity_note_list_list);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));

        mNoteAdapter = new NoteAdapter(new ArrayList<Note>());
        list.setAdapter(mNoteAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE_CREATE:
                if (resultCode == RESULT_OK) {
                    if (data.hasExtra(CreateNoteActivity.ARG_NOTE)) {
                        Note note = data.getParcelableExtra(CreateNoteActivity.ARG_NOTE);
                        mNoteAdapter.addNote(note);
                        mNoteAdapter.notifyDataSetChanged();
                    }
                }
                break;
            default:
                break;
        }
    }
}
