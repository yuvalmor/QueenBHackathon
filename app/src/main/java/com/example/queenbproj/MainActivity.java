package com.example.queenbproj;

import android.content.Context;
import android.content.Intent;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.view.View;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static List<Task> allTasks;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        allTasks  = new ArrayList<Task>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //insert list from file (Stav & almog TODOOOOOOOOOOOOOOOOOO)
        Task t1 = new Task("OS", "HW4", "blabla", 3, new Date(1,1,1990));
        t1.setTitle("HW 4");
        t1.setParts(4);
        taskList = new ArrayList<>();
        taskList.add(t1);

        // specify an adapter (see also next example)
        mAdapter = new TaskAdapter(taskList);
        recyclerView.setAdapter(mAdapter);
    }

    public void createTask(View view){
        Intent taskIntent = new Intent(this, AddTask.class);

        //start the activity
        startActivity(taskIntent);
    }


}
