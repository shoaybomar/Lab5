package com.example.lab5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import com.example.lab5.CustomAdapter;
import com.example.lab5.DatabaseHelper;
import com.example.lab5.R;

public class MainActivity extends AppCompatActivity {
    private EditText taskEditText;
    private CustomAdapter todoAdapter;
    private ArrayList<TodoItem> todoList;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskEditText = findViewById(R.id.taskEditText);
        Button addButton = findViewById(R.id.addButton);
        ListView todoListView = findViewById(R.id.todoListView);

        dbHelper = new DatabaseHelper(this);
        todoList = dbHelper.getAllTodos();

        todoAdapter = new CustomAdapter(this, todoList);
        todoListView.setAdapter(todoAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = taskEditText.getText().toString().trim();
                if (!task.isEmpty()) {
                    // Add the task to the database
                    long id = dbHelper.insertTodo(task, 1); // Replace '1' with the actual urgency
                    if (id > -1) {
                        todoList.add(new TodoItem((int) id, task, 1));
                        todoAdapter.notifyDataSetChanged();
                        taskEditText.getText().clear();
                    }
                }
            }
        });
    }
}