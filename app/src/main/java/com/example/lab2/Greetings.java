package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Greetings extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings);
        findViewById(R.id.english).setOnClickListener(this);
        findViewById(R.id.russian).setOnClickListener(this);
        findViewById(R.id.german).setOnClickListener(this);
        findViewById(R.id.what).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView greeting = findViewById(R.id.greeting);
        EditText editor = findViewById(R.id.name);
        String name = editor.getText().toString();
        if(v.getId() == R.id.english){
            greeting.setText("Hello "+ name +"!");
        }
        if(v.getId() == R.id.russian){
            greeting.setText("Привет "+ name + "!");
        }
        if(v.getId() == R.id.german){
            greeting.setText("Guten tag "+ name + "!");
        }
        if(v.getId() == R.id.what){
            greeting.setText("Who are you "+ name + "?");
        }
    }
}
