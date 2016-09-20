package com.databinding.notes.viewmodel;

import android.content.Intent;
import android.view.View;

import com.databinding.notes.model.Note;
import com.databinding.notes.ui.CreateNoteActivity;

import static android.app.Activity.RESULT_OK;
import static com.databinding.notes.ui.CreateNoteActivity.ARG_NOTE;

/**
 * Created by Raul on 9/20/16.
 */

public class CreateNoteViewModel extends NoteViewModel {
    private CreateNoteActivity mActivity;

    public CreateNoteViewModel(CreateNoteActivity activity) {
        super(new Note());
        this.mActivity = activity;
    }



    public void onSaveNoteClick(View view) {
        if (!mNote.getTitle().isEmpty() || !mNote.getBody().isEmpty()) {
            Intent resultIntent = new Intent();
            resultIntent.putExtra(ARG_NOTE, mNote);

            mActivity.setResult(RESULT_OK, resultIntent);
            mActivity.finish();
        }
    }
}
