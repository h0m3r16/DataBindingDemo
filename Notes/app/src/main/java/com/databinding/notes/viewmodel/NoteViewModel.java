package com.databinding.notes.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.databinding.notes.model.Note;

/**
 * Created by Raul on 9/20/16.
 */

public class NoteViewModel extends BaseObservable {
    protected Note mNote;

    public NoteViewModel(Note note) {
        mNote = note;
    }

    @Bindable
    public String getTitle() {
        return mNote.getTitle();
    }

    @Bindable
    public void setTitle(String title) {
        mNote.setTitle(title);
    }

    @Bindable
    public String getBody() {
        return mNote.getBody();
    }

    @Bindable
    public void setBody(String body) {
        mNote.setBody(body);
    }
}
