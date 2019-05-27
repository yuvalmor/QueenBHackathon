package com.example.queenbproj;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.time.format.DateTimeFormatter;
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
    public void onBindViewHolder(ViewHolder holder, int position) {
        Task task = taskList.get(position);
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(task.getTitle() + " / " + task.getCourse());
        holder.submit_date.setText("sumbit date: " + task.getSubmitDate().toString());
        String time_left = "time left ";



       // holder.days_left.setText();
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