package com.example.otpfinal;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;


public class OTP_Receiver extends BroadcastReceiver
{
    private static EditText editText1;
    @TargetApi(Build.VERSION_CODES.M)

    public void setEditText(EditText editText)
    {
        OTP_Receiver.editText1 = editText;
    }


    @Override
    public void onReceive(Context context, Intent intent)
    {

        SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);


        for (SmsMessage sms : messages)
        {
            String message = sms.getMessageBody();
            String smsmessage=sms.getOriginatingAddress();


            if (smsmessage.contains("Jio")||smsmessage.contains("ICICI")||smsmessage.contains("6505551212"))
            {
                editText1.setText(smsmessage);
            }



        }




    }



    }





