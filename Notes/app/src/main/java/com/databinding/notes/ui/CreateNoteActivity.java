package com.databinding.notes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.databinding.notes.R;
import com.databinding.notes.model.Note;

public class CreateNoteActivity extends AppCompatActivity {

    public static final String ARG_NOTE = "note";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.activity_create_note_fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText title = (EditText) findViewById(R.id.activity_create_note_title);
                EditText body = (EditText) findViewById(R.id.activity_create_note_body);

                if (!title.getText().toString().isEmpty() || !body.getText().toString().isEmpty()) {
                    Note note = new Note(title.getText().toString(), body.getText().toString());

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(ARG_NOTE, note);

                    CreateNoteActivity.this.setResult(RESULT_OK, resultIntent);
                    CreateNoteActivity.this.finish();
                }
            }
        });
    }

}
