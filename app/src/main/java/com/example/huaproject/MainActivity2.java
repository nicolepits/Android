package com.example.huaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private Spinner spinner; //Spinner used for timestamp selection
    public DbHelper helper;
    public String dt;
    static EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spinner = findViewById(R.id.spinner);
        List<User> myList;
        helper = new DbHelper(MainActivity2.this);
        myList = helper.getResults();
        ArrayList<String> objects = new ArrayList();

        //Get a list of all stored timestamps in database
        for (User u : myList) {
            objects.add(u.getDt());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, objects); //create an adapter for spinner with the listed timestamps

        spinner.setAdapter(adapter); //set the adapter

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                dt = objects.get(position); //retrieves selected timestamp
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(buttonClk);
    }

        public View.OnClickListener buttonClk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.button :
                        /*
                        create a new intent, store in it the two selected values (timestamp and userid)
                        and start next Activity
                         */
                            Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                            editText = findViewById(R.id.editTextQueryID);
                            i.putExtra("userid", editText.getText().toString());
                            i.putExtra("dt", dt);
                            startActivity(i);
                            break;

                }
            }
        };


}