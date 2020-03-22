package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class CountriesActivity extends AppCompatActivity implements View.OnClickListener{
    ArrayList<String> countries;
    final String[] COUNTRIES = new String[] {
            "Afganistan", "Albania", "Algeria", "American Samoa",
            "Andorra", "Angola", "Anguilla", "Antarctida", "Antigua and Barbuda",
            "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        countries = new ArrayList<>();
        countries.addAll(0, Arrays.asList(COUNTRIES));
        Log.i("array", countries.get(2));
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

        findViewById(0).setOnClickListener(this);
        findViewById(2).setOnClickListener(this);


        EditText editText = new EditText(this);
        editText.setId(5);

        mainLayout.addView(editText);

        ListView listView = new ListView(this);
        listView.setId(3);
        mainLayout.addView(listView);
        ListView myListView = (ListView) findViewById(3);
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        myListView.setAdapter(aa);
    }
    @Override
    public void onClick(View view) {
        if(view.getId() == 0){
            EditText editor = findViewById(5);
            String text = editor.getText().toString();
            countries.add(text);
            Log.i("asd", text);
        }
        if(view.getId() == 2){
            EditText editor = findViewById(5);
            String text = editor.getText().toString().trim();
            for (int i = 0; i < countries.size(); i++) {
                if (countries.get(i).indexOf(text) != -1){
//                    Log.i("asd", text);
                    countries.remove(i);
                }
            }

        }
        updateListUi();
    }
    private void updateListUi() {
//        ToDoModel model = ToDoApplication.getModel(this);
        ListView listView = (ListView) findViewById(3);
        ArrayList<String> itemTexts = countries;

        Log.d("array", itemTexts.get(0));
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemTexts);
        listView.setAdapter(itemsAdapter);
    }
}
