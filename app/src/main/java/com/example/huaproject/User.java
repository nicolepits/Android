package com.example.huaproject;

public class User { //Data object mapping

    private int id;
    private String userId;
    private float longitude;
    private float latitude;
    private String dt;

    public User(String userId, float longitude, float latitude, String dt) {
        this.userId = userId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.dt = dt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserI(String userId){
        this.userId= userId;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }
}
