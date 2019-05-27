package com.example.queenbproj;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    List<Task> taskList;

    // Provide a suitable constructor (depends on the kind of dataset)
    public TaskAdapter(List<Task> taskList) {

        this.taskList = taskList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_task_view, parent, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position)  {
        Task task = taskList.get(position);
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(task.getTitle() + " on Course:" + task.getCourse());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = "";
        try {
             date = simpleDateFormat.format(task.getSubmitDate());
        } catch (Exception e){}
        holder.submit_date.setText("submit date: " + date);

        String time_left = "time left ";


        Calendar thatDay = Calendar.getInstance();
        thatDay.set(Calendar.DAY_OF_MONTH,30);
        thatDay.set(Calendar.MONTH,5); // 0-11 so 1 less
        thatDay.set(Calendar.YEAR, 2019);

        Calendar today = Calendar.getInstance();
        today.set(Calendar.DAY_OF_MONTH,27);
        today.set(Calendar.MONTH,5); // 0-11 so 1 less
        today.set(Calendar.YEAR, 2019);

        long diff =  thatDay.getTimeInMillis()-today.getTimeInMillis(); //result in millis
        long days = diff / (24 * 60 * 60 * 1000);
        holder.days_left.setText(days+" left");

        //holder.getCustomView().setData();
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return taskList.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView submit_date;
        TextView description;
        TextView days_left;

        ViewHolder(View v) {

            super(v);

            textView = v.findViewById(R.id.title);
            submit_date = v.findViewById(R.id.date);
            description = v.findViewById(R.id.details);
            days_left = v.findViewById(R.id.days_left);

        }
    }

}