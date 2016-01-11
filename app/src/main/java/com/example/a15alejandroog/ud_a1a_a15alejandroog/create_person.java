package com.example.a15alejandroog.ud_a1a_a15alejandroog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class create_person extends AppCompatActivity {
    CreateDataBase db = new CreateDataBase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_person);

        Button button = (Button) findViewById(R.id.btn_create);
        final EditText et_name = (EditText) findViewById(R.id.et_name);
        final EditText et_description = (EditText) findViewById(R.id.et_description);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_name.getText().toString().equals("") && !et_description.getText().toString().equals("")){
                    Persoa person = new Persoa(et_name.getText().toString(), et_description.getText().toString());
                    db.addPerson(person);
                    finish();
                } else{
                    Toast.makeText(getApplicationContext(), getString(R.string.no_data), Toast.LENGTH_SHORT).show();
                }
            }
        });
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
