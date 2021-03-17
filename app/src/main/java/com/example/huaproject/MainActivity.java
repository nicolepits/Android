package com.example.huaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public DbHelper helper;
    static EditText editText1;
    static EditText editText2;
    static EditText editText3;
    static EditText editText4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PowerReceiver receiver = new PowerReceiver();
        receiver.onReceive(MainActivity.this, getIntent());
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        editText1 = findViewById(R.id.editTextUserID);
        editText2 = findViewById(R.id.editTextLongitude);
        editText3 = findViewById(R.id.editTextLatitude);
        editText4 = findViewById(R.id.editTextDt);

        helper = new DbHelper(MainActivity.this);
        Toast.makeText(MainActivity.this," Db Success!",Toast.LENGTH_SHORT).show();
        button1.setOnClickListener(buttonClk);
        button2.setOnClickListener(buttonClk);

        }


    public View.OnClickListener buttonClk = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1: //Case 1 : Insert info in database

                    //get info from edittexts
                    String userID = editText1.getText().toString();
                    String tmpLong = editText2.getText().toString();
                    float longitude = Float.parseFloat(tmpLong);
                    String tmpLat = editText3.getText().toString();
                    float latitude = Float.parseFloat(tmpLat);
                    String dt = editText4.getText().toString();
                    //Create user object
                    User user = new User(userID, longitude, latitude, dt);
                    //Insert into our database
                    helper.insertInfo(user);
                    Toast.makeText(MainActivity.this, "User inserted", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.button2: //Case 2 : Go to next activity for timestamp selection
                    Intent intent = new Intent( MainActivity.this, MainActivity2.class); //create an intent
                    startActivity(intent);
                    break;

            }
        }
    };
}