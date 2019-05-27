package com.example.queenbproj;

import android.app.DatePickerDialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddTask extends AppCompatActivity {

    DatePickerDialog picker;
    EditText eText;
    Button btnGet;
    TextView tvw;

    EditText courseName;
    EditText title;
    //EditText date;
    EditText description;
    EditText parts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        this.setTitle("Add Task");

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //setTitle("Task");

        courseName = (EditText)findViewById(R.id.CourseName);
        title = (EditText)findViewById(R.id.TaskName);
        description = (EditText)findViewById(R.id.TaskDescription);
        parts = (EditText)findViewById(R.id.partsText);

        //tvw=(TextView)findViewById(R.id.textView1);
        eText=(EditText) findViewById(R.id.editText1);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(AddTask.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

    }

    public void finishClick(View view){
        String value= this.parts.getText().toString();
        int finalValue=Integer.parseInt(value);
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(this.eText.getText().toString());
            Task task=new Task(this.courseName.getText().toString(),this.title.getText().toString(),
                    this.description.getText().toString(),finalValue,date);
            //file
          //  FileHandler fileHandler = new FileHandler();
          //  fileHandler.WriteTask(task,this);
            MainActivity.allTasks.add(task);
            Toast message = Toast.makeText(this, "Task Added!",
                    Toast.LENGTH_SHORT);
            message.show();
            finish();
        } catch (ParseException e) {

        }

    }

}
