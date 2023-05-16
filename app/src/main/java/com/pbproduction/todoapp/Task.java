package com.pbproduction.todoapp;

import java.util.Date;

public class Task {
    private String title;
    private boolean completed;
    private Date date;
    private String description;

    public Task(String title) {
        this.title = title;
        this.completed = false;
    }
    public Task(String title, Date date, String description){
        this.title = title;
        this.date = date;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
