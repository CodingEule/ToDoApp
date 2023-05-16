package com.pbproduction.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private List<Task> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Hier können Sie Aufgaben hinzufügen, wenn die Aktivität erstellt wird
        tasks.add(new Task("Einkaufen"));
        tasks.add(new Task("Wäsche waschen"));

        // Anzeigen der Aufgabenliste
        ListView listView = findViewById(R.id.list_view);
        TaskListAdapter adapter = new TaskListAdapter(this, tasks);
        listView.setAdapter(adapter);


        ImageButton addBtn = findViewById(R.id.addBtn);
        EditText textAdd = findViewById(R.id.text_add_toDo);

        // funktion addBtn
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // abfragen ob textAdd leer ist
                if(textAdd.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Das Feld darf nicht leer sein", Toast.LENGTH_SHORT).show();
                }else{
                    //wenn nicht dann aufgabe hinzufügen und text feld leeren
                    tasks.add(new Task(textAdd.getText().toString()));
                    adapter.notifyDataSetChanged();
                    textAdd.setText("");

                }

            }
        });

















    }
}
