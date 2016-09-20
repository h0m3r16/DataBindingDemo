package com.databinding.notes.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.databinding.notes.R;
import com.databinding.notes.databinding.ActivityCreateNoteBinding;
import com.databinding.notes.model.Note;

public class CreateNoteActivity extends AppCompatActivity {

    public static final String ARG_NOTE = "note";

    private Note mNote = new Note();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityCreateNoteBinding createNoteBinding = DataBindingUtil.setContentView(this, R.layout.activity_create_note);
        createNoteBinding.setListener(this);
        createNoteBinding.contentInclude.setNote(mNote);

        setSupportActionBar(createNoteBinding.toolbarInclude.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onSaveNoteClick(View view) {
        if (!mNote.getTitle().isEmpty() || !mNote.getBody().isEmpty()) {
            Intent resultIntent = new Intent();
            resultIntent.putExtra(ARG_NOTE, mNote);

            CreateNoteActivity.this.setResult(RESULT_OK, resultIntent);
            CreateNoteActivity.this.finish();
        }
    }

}
