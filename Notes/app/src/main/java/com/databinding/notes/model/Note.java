package com.databinding.notes.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Raul on 9/13/16.
 */
public class Note implements Parcelable {
    public static final Parcelable.Creator<Note> CREATOR = new Parcelable.Creator<Note>() {
        public Note createFromParcel(Parcel source) {
            return new Note(source);
        }

        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
    private String mTitle;
    private String mBody;

    public Note() {
    }

    public Note(String title, String body) {
        mTitle = title;
        mBody = body;
    }

    protected Note(Parcel in) {
        this.mTitle = in.readString();
        this.mBody = in.readString();
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mTitle);
        dest.writeString(this.mBody);
    }
}
