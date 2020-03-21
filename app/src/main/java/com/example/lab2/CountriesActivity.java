package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class CountriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        LinearLayout.LayoutParams main = new LinearLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setLayoutParams(main);
        setContentView(mainLayout);

        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        linearParams.gravity =  Gravity.CENTER_HORIZONTAL;
        linearLayout.setLayoutParams(linearParams);
        mainLayout.addView(linearLayout);


        Button addBtn = new Button(this);
        addBtn.setId(0);
        addBtn.setText("Add");
        linearLayout.addView(addBtn);
        Button editButton = new Button(this);
        editButton.setText("Edit");
        editButton.setId(1);
        linearLayout.addView(editButton);
        Button removeButton = new Button(this);
        removeButton.setText("Remove");
        linearLayout.addView(removeButton);
        removeButton.setId(2);

        EditText editText = new EditText(this);
        mainLayout.addView(editText);

        ListView listView = new ListView(this);
        listView.setId(3);
        mainLayout.addView(listView);

        final String[] COUNTRIES = new String[] {
                "Afganistan", "Albania", "Algeria", "American Samoa",
                "Andorra", "Angola", "Anguilla", "Antarctida", "Antigua and Barbuda",
                "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan"
        };
        ListView myListView = (ListView) findViewById(3);
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, COUNTRIES);
        myListView.setAdapter(aa);
    }
}
