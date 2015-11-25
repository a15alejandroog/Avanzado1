package com.example.a15alejandroog.ud_a1a_a15alejandroog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class show_people extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_people);
        CreateDataBase dataBase = new CreateDataBase(this);

        Spinner spinner = (Spinner) findViewById(R.id.spin_people);

        //ArrayList<Persoa> people = dataBase.listPeople();
        ArrayList<Persoa> people = new ArrayList<>();

        people.add(new Persoa("nome1", "descricion1"));
        people.add(new Persoa("nome2", "descricion2"));

        final ArrayList<String> peopleNames = new ArrayList<>();

        for (Persoa person : people){
            peopleNames.add(person.getNome());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, peopleNames);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("NAME", peopleNames.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
