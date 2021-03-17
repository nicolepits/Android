package com.example.huaproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

public class PowerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING;
                //|| status == BatteryManager.BATTERY_STATUS_FULL;
        if (isCharging){
            Toast.makeText(context, "The device is charging", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "The device is not charging", Toast.LENGTH_SHORT).show();

        }

    }
}