package com.example.otpfinal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.EditText;
import android.widget.Toast;


public class OTP_Receiver extends BroadcastReceiver
{
    private static EditText editText1;

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
            if (message.contains("From")||message.contains("To")||message.contains("Ansh"))
            {
                editText1.setText(message);
            }



        }
    }





}