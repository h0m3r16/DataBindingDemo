package com.databinding.notes.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.databinding.notes.R;
import com.databinding.notes.databinding.ListItemNoteBinding;
import com.databinding.notes.model.Note;

import java.util.ArrayList;

/**
 * Created by Raul on 9/13/16.
 */
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private ArrayList<Note> mData;


    public NoteAdapter(ArrayList<Note> data) {
        mData = data;
    }

    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_note, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Note note = mData.get(position);
        holder.mListItemNoteBinding.setNote(note);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addNote(Note note) {
        mData.add(note);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ListItemNoteBinding mListItemNoteBinding;

        public ViewHolder(View view) {
            super(view);
            mListItemNoteBinding = DataBindingUtil.bind(view);
        }
    }
}


