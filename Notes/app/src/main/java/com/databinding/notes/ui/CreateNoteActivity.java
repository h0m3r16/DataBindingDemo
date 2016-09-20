package com.databinding.notes.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.databinding.notes.R;
import com.databinding.notes.databinding.ActivityCreateNoteBinding;
import com.databinding.notes.model.Note;
import com.databinding.notes.viewmodel.CreateNoteViewModel;

public class CreateNoteActivity extends AppCompatActivity {

    public static final String ARG_NOTE = "note";

    private CreateNoteViewModel mCreateNoteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityCreateNoteBinding createNoteBinding = DataBindingUtil.setContentView(this, R.layout.activity_create_note);
        mCreateNoteViewModel = new CreateNoteViewModel(this);
        createNoteBinding.setViewModel(mCreateNoteViewModel);
        createNoteBinding.contentInclude.setViewModel(mCreateNoteViewModel);

        setSupportActionBar(createNoteBinding.toolbarInclude.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
