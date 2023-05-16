package com.pbproduction.todoapp;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class TaskListAdapter extends ArrayAdapter<Task> {
    private Context context;
    private List<Task> tasks;

    public TaskListAdapter(Context context, List<Task> tasks) {
        super(context, 0, tasks);
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.task_item, parent, false);
        }

        Task task = tasks.get(position);

        TextView titleTextView = convertView.findViewById(R.id.title_text_view);
        titleTextView.setText(task.getTitle());

        CheckBox completedCheckBox = convertView.findViewById(R.id.completed_check_box);
        completedCheckBox.setChecked(task.isCompleted());

        ImageButton deleteBtn = convertView.findViewById(R.id.deleteBtn);


        //funktion des Delete Button Implementiert.
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //entfernt element
                remove(getItem(position));
                //gibt bescheid das daten sich verändert haben.
                notifyDataSetChanged();

            }
        });

        //task_details view anzeigen

        titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, task_details_activity.class);
                intent.putExtra("taskTitle", task.getTitle());
                intent.putExtra("taskDescription", task.getDescription());
                intent.putExtra("taskDate", task.getDate());
                intent.putExtra("position", position);
                intent.putExtra("task", task);
                context.startActivity(intent);



            }
        });


        completedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                task.setCompleted(isChecked);
            }
        });

        return convertView;
    }

}
