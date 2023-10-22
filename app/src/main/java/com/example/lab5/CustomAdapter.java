package com.example.lab5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lab5.R;
import com.example.lab5.TodoItem;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<TodoItem> todoList;

    public CustomAdapter(Context context, ArrayList<TodoItem> todoList) {
        this.context = context;
        this.todoList = todoList;
    }

    @Override
    public int getCount() {
        return todoList.size();
    }

    @Override
    public Object getItem(int position) {
        return todoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.todo_item, parent, false);
        }

        TodoItem todoItem = (TodoItem) getItem(position);

        TextView taskTextView = convertView.findViewById(R.id.taskTextView);
        TextView urgencyTextView = convertView.findViewById(R.id.urgencyTextView);

        taskTextView.setText(todoItem.getTask());
        urgencyTextView.setText(String.valueOf(todoItem.getUrgency()));

        return convertView;
    }
}