package com.pbproduction.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

// Klasse für die Beschreibung und Datumswahl einer Aufgabe
public class task_details_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_details_activity);

        //View Id zuweisen
        EditText taskTitleDetails = findViewById(R.id.task_title_details);
        EditText taskDescriptionDetails = findViewById(R.id.task_description_details);
        EditText selectDate = findViewById(R.id.select_date_details);
        AppCompatButton detailCancelBtn = findViewById(R.id.task_detail_cancel_btn);
        AppCompatButton detailAcceptBtn = findViewById(R.id.task_detail_accept_btn);

        //title auf vorher ausgewählten Title Setzen.
        Intent intent = getIntent();
        if(intent != null){
            String taskTitle = intent.getStringExtra("taskTitle");
            if(taskTitle != null){
                taskTitleDetails.setText(taskTitle);
            }
        }

        //prüfen ob description vorhanden ist und anzeigen wenn
        String taskDescription = intent.getStringExtra("taskDescription");
        if(taskDescription != null){
            taskDescriptionDetails.setText(taskDescription);
        }

        //prüfen ob date vorhanden ist und anzeigen wenn
        String taskDate = intent.getStringExtra("taskDate");
        if(taskDate != null){
            selectDate.setText(taskDate);
        }

        //Date Picker wird eingerichtet
               selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aktuelles Datum abrufen
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                //Datepicker Dialog erstellen und anzeigen
                DatePickerDialog datePickerDialog = new DatePickerDialog(task_details_activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        //Ausgewähltes Datum im EditText-Feld setzen
                        String selectedDate = String.format(Locale.getDefault(), "%02d.%02d.%04d", dayOfMonth, (month + 1), year);
                        selectDate.setText(selectedDate);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        // funktion des detailCancelBtn in der task_details.xml
        detailCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

        //funktion des detailAcceptBtn in der task_detail.xml
        detailAcceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description = taskDescriptionDetails.getText().toString();
                String date = selectDate.getText().toString();
                String title = taskTitleDetails.getText().toString();
                Task task = getIntent().getParcelableExtra("task");

                if(task != null){
                    task.setDate(date);
                    task.setDescription(description);
                    task.setTitle(title);
                }

                finish();
            }
        });

    }
}