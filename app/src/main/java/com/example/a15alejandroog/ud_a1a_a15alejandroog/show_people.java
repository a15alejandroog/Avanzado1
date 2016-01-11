package com.example.a15alejandroog.ud_a1a_a15alejandroog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class show_people extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_people);
        CreateDataBase dataBase = new CreateDataBase(this);

        final Spinner spinner = (Spinner) findViewById(R.id.spin_people);
        final TextView textView = (TextView) findViewById(R.id.tv_description);
        final Button btn_save = (Button) findViewById(R.id.btn_save);

        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        dataBase.getReadableDatabase();
        final ArrayList<Persoa> people = dataBase.listPeople();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (spinner.getSelectedItemId() >= 0) {
                    if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                        String directoryName = preferences.getString("ID_PREF_DB", "DATOS");
                        String path = Environment.getExternalStorageDirectory() + File.separator + directoryName;
                        File directory = new File(path);
                        Log.i("DIRECTORY", directory.getAbsolutePath());

                        if (!directory.exists()) {
                            directory.mkdirs();
                            Log.i("DIRECTORY", "CREATED");

                        }

                        try {
                            File file = new File(path, spinner.getSelectedItem().toString() + ".txt");
                            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

                            outputStreamWriter.write(spinner.getSelectedItem().toString() + "\n");
                            outputStreamWriter.write(textView.toString() + "\n");
                            outputStreamWriter.close();
                            fileOutputStream.close();

                        } catch (Exception ex) {
                            Log.e("FILE", ex.getMessage());
                        }
                    } else {
                        Log.e("SDCARD", Environment.getExternalStorageState());
                    }
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.no_person), Toast.LENGTH_SHORT).show();
                }
            }
        });

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
            textView.setText(getString(R.string.no_people));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(getApplicationContext(), Preferences.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}
