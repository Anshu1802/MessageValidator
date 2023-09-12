package com.example.otpfinal;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {


    private String[] keyword = {"From", "To", "Here"};

    public void onReceive(Context context, Intent intent) {

        Object[] pdus = (Object[])intent.getExtras().get("pdus");
        SmsMessage shortMessage = SmsMessage.createFromPdu((byte[])pdus[0]);
        if(shortMessage.getDisplayMessageBody().equals(keyword)) {
            Toast.makeText(context, keyword.toString(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, keyword.toString(), Toast.LENGTH_LONG).show();
        }
    }
}