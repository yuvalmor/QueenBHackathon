package com.example.queenbproj;

import android.app.Activity;
import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHandler {
    //read and write tasks to file
    private  static final String fileName  = "C:\\Users\\almog\\tasks.ser";

    public void WriteTask(Task task,Context context){
       // File file = new File(context.getFilesDir(), fileName);
        try {
            File file = new File(context.getFilesDir(), fileName);
           // FileOutputStream fos = new FileOutputStream(file);
           // FileOutputStream fos = null;
             FileOutputStream outputStream = context.openFileOutput(fileName,Context.MODE_PRIVATE);

            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(task);
            oos.close();
            outputStream.close();
        }catch (Exception e){
            System.out.println("FAILED");
        }
        ArrayList<Task> tasks=ReadTasks();
    }
    public ArrayList<Task> ReadTasks(){
        ArrayList<Task> tasks=null;
        try{
            FileInputStream fis=new FileInputStream(fileName);
            ObjectInputStream ois=new ObjectInputStream(fis);
            tasks=(ArrayList)ois.readObject();
            ois.close();
            fis.close();
        }catch (Exception e){

        }
        return tasks;
    }
}
