package com.pbproduction.todoapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Task  implements Parcelable {
    private String title;
    private boolean completed;
    private String date;
    private String description;

    public Task(String title) {
        this.title = title;
        this.completed = false;
    }
    public Task(String title, String date, String description){
        this.title = title;
        this.date = date;
        this.description = description;
        this.completed = false;
    }
    protected Task(Parcel in){
        title = in.readString();
        description = in.readString();
        date = in.readString();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int i) {
            return new Task[i];
        }
    };

    @Override
    public int describeContents(){
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(date);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
