package com.example.lab5;

public class TodoItem {
    private int id;
    private String task;
    private int urgency;

    public TodoItem(int id, String task, int urgency) {
        this.id = id;
        this.task = task;
        this.urgency = urgency;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public int getUrgency() {
        return urgency;
    }
}