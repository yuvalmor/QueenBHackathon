package com.example.queenbproj;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static List<Task> allTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        allTasks  = new ArrayList<Task>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createTask(View view){
        Intent taskIntent = new Intent(this,AddTask.class);

        //start the activity
        startActivity(taskIntent);
    }


}
