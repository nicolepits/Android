package com.example.huaproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    /*
    This class is responsible for the database connection and retrieving info from our database
     */

    public static String DB_NAME = "UsersDB";
    public static String TABLE_NAME = "Users";
    public static String FIELD_1 = "id";
    public static String FIELD_2 = "usersid";
    public static String FIELD_3 = "longitude";
    public static String FIELD_4 = "latitude";
    public static String FIELD_5 = "dt";
    private String SQL_QUERY = "CREATE TABLE "+TABLE_NAME+" ("+FIELD_1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+FIELD_2+" VARCHAR, "+FIELD_3+" FLOAT, "+FIELD_4+" FLOAT , "+FIELD_5+" VARCHAR)";

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertInfo(User user){
        ContentValues values = new ContentValues();
        values.put(FIELD_2,user.getUserId());
        values.put(FIELD_3,user.getLongitude());
        values.put(FIELD_4,user.getLatitude());
        values.put(FIELD_5,user.getDt());
        long id = this.getWritableDatabase().insert(TABLE_NAME,null,values);
        return id;
    }

    //get a list of all users stored in our database
    public List<User> getResults(){

        //create empty list
        List<User> list = new ArrayList<User>();

        //get database and create cursor
        SQLiteDatabase myDb = this.getReadableDatabase();
        String[] field = {FIELD_1,FIELD_2,FIELD_3,FIELD_4,FIELD_5};
        Cursor c = myDb.query(TABLE_NAME, field, null, null, null, null, null);

        //get indexes
        int i_id = c.getColumnIndex(FIELD_1);
        int i_userid = c.getColumnIndex(FIELD_2);
        int i_longitude = c.getColumnIndex(FIELD_3);
        int i_latitude = c.getColumnIndex(FIELD_4);
        int i_dt = c.getColumnIndex(FIELD_5);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            int id = c.getInt(i_id);
            String userid = c.getString(i_userid);
            Float longitude = c.getFloat(i_longitude);
            Float latitude = c.getFloat(i_latitude);
            String dt = c.getString(i_dt);
            User user = new User(userid,longitude,latitude,dt);
            user.setId(id);
            list.add(user);
        }

        return list;
    }

    //retrieve user's info using userid and timestamp string
    public List<User> getUsers(String userId, String dt){

        List<User> list = this.getResults();
        List<User> result = new ArrayList<>();
        for(User u: list){
            if(u.getUserId().contains(userId) && u.getDt().contains(dt)){
                result.add(u);
            }
         }
        return result;
    }
}