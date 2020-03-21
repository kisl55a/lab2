package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            final int[] clicks = {0};
            final Button gameButton = new Button(this);
            gameButton.setText("Hello, I'm the button. Press me!");
            setContentView(gameButton);
    //        setContentView(R.layout.activity_main);
            gameButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    gameButton.setText("You have clicked the button "+ clicks[0] +" times");
                    clicks[0] = clicks[0] + 1;
                }
            });
    }

}
