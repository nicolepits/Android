package com.example.huaproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.huaproject.User;

import java.util.ArrayList;

public class AdapterUser extends ArrayAdapter<String> {

    /*
    Adapter class for users in 3rd activity's list
     */
    private final Activity context;
    private final String[] userid;
    private final Float[] longtitude;
    private final Float[] latitude;
    private final String[] dt;


    public AdapterUser(Activity context, String[] userid, Float[] longtitude, Float[] latitude, String[] dt) {
        super(context, R.layout.my_list, userid);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.userid = userid;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.dt = dt;
    }

    //customized View for list -> set textviews in list
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.my_list, null,true);

        TextView userIDText = (TextView) rowView.findViewById(R.id.userid);
        TextView longtitudeText = (TextView) rowView.findViewById(R.id.longtitude);
        TextView latitudeText = (TextView) rowView.findViewById(R.id.latitude);
        TextView dtText = (TextView) rowView.findViewById(R.id.dt);

        userIDText.setText("User ID: " + userid[position]);
        longtitudeText.setText("Longtitude: " + longtitude[position].toString());
        latitudeText.setText("Latitude: " + latitude[position].toString());
        dtText.setText("Timestamp: " + dt[position]);


        return rowView;

    };

}