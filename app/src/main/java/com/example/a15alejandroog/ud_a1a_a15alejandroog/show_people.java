package com.example.a15alejandroog.ud_a1a_a15alejandroog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class show_people extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_people);
        CreateDataBase dataBase = new CreateDataBase(this);

        final Spinner spinner = (Spinner) findViewById(R.id.spin_people);
        final TextView textView = (TextView) findViewById(R.id.tv_description);

        dataBase.getReadableDatabase();
        final ArrayList<Persoa> people = dataBase.listPeople();

        if (!people.isEmpty()) {
            final ArrayList<String> peopleNames = new ArrayList<>();

            for (Persoa person : people) {
                peopleNames.add(person.getNome());
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, peopleNames);
            spinner.setAdapter(arrayAdapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    textView.setText(people.get(position).getDescricion());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } else {
            textView.setText("No people to show");
        }
    }
}
