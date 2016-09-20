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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityCreateNoteBinding createNoteBinding = DataBindingUtil.setContentView(this, R.layout.activity_create_note);

        setSupportActionBar(createNoteBinding.toolbarInclude.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        createNoteBinding.activityCreateNoteFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!createNoteBinding.contentInclude.activityCreateNoteTitle.getText().toString().isEmpty() ||
                        !createNoteBinding.contentInclude.activityCreateNoteBody.getText().toString().isEmpty()) {
                    Note note = new Note(createNoteBinding.contentInclude.activityCreateNoteTitle.getText().toString(),
                            createNoteBinding.contentInclude.activityCreateNoteBody.getText().toString());

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(ARG_NOTE, note);

                    CreateNoteActivity.this.setResult(RESULT_OK, resultIntent);
                    CreateNoteActivity.this.finish();
                }
            }
        });
    }

}
