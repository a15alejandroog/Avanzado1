package com.example.a15alejandroog.ud_a1a_a15alejandroog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class UD_A1A_a15alejandroog extends AppCompatActivity {

    Button btn_show;
    Button btn_create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ud__a1_a_a15alejandroog);

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
}
