package com.example.a15alejandroog.ud_a1a_a15alejandroog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class UD_A1A_a15alejandroog extends AppCompatActivity {

    private CreateDataBase dataBase;
    AlertDialog.Builder alert;
    Button btn_show;
    String dataBasePath;
    Button btn_create;
    final int ACT_SHOW = 32;
    final int ACT_CREATE = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ud__a1_a_a15alejandroog);

        dataBasePath = "/data/data/" + getPackageName() + "/databases/" + CreateDataBase.DB_NAME;
        File dBase = new File(dataBasePath);

        if (!dBase.exists()) {
            alert = new AlertDialog.Builder(this);
            alert.setIcon(android.R.drawable.ic_dialog_alert);
            alert.setTitle(getString(R.string.dialog_title));
            alert.setItems(R.array.choices, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case 0:
                            dataBase = new CreateDataBase(getApplicationContext());
                            dataBase.getWritableDatabase();
                            Toast.makeText(getApplicationContext(), getString(R.string.created), Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            
                            break;
                    }
                }
            });
            alert.show();

        }

        btn_create = (Button) findViewById(R.id.btn_create_person);
        btn_show = (Button) findViewById(R.id.btn_show_people);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), create_person.class);
                startActivity(intent);
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), show_people.class);
                startActivity(intent);
            }
        });
    }

    private void copyDB(){

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
