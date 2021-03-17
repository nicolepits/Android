package com.example.huaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    /*
    Here I used a list to print user's info that is found from the query
     */
    public DbHelper helper;
    String[] id_arr;
    Float[] long_arr;
    Float[] lat_arr;
    String[] dt_arr;
    ListView list;

    ArrayList<String> results = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();

        //retrieve selected info from previous activity using the intent we created
        String userID = intent.getStringExtra("userid");
        String dt = intent.getStringExtra("dt");

        helper = new DbHelper(MainActivity3.this);
        List<User> users = helper.getUsers(userID,dt); //get users that have both userid and timestamp

        //create String Arrays for List's fields
        id_arr = new String[users.size()];
        long_arr= new Float[users.size()];;
        lat_arr= new Float[users.size()];;
        dt_arr= new String[users.size()];;

        int j = 0;
        //Fill in the String arrays with the detected users from Query
        for( User u : users){
            id_arr[j] = u.getUserId();
            long_arr[j] = u.getLongitude();
            lat_arr[j] = u.getLatitude();
            dt_arr[j] = u.getDt();
            j++;
        }

        //Create our customized adapter and set it
        AdapterUser adapter=new AdapterUser(this,id_arr, long_arr,lat_arr,dt_arr);
        list=(ListView)findViewById(R.id.simpleListView);
        list.setAdapter(adapter);

    }
}