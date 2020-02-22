package com.example.llamada;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Event", Toast.LENGTH_LONG).show();
        TelephonyManager telephonyManager=(TelephonyManager)context.getSystemService(Service.TELEPHONY_SERVICE);
        int state=telephonyManager.getCallState();
        if(state==TelephonyManager.CALL_STATE_IDLE){
            SmsManager smsManager=SmsManager.getDefault();
            smsManager.sendTextMessage("4451323685",
                    null,
                    "No pude contestar, perdón",
                    null,
                    null);
        }
    }
}
