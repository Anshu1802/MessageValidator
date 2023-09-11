package com.example.otpfinal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.EditText;
import android.widget.Toast;

public class OTP_Receiver_keyword extends BroadcastReceiver {

    private static EditText editText1;
    public void setEditText(EditText editText)
    {
        OTP_Receiver_keyword.editText1 = editText;
    }
    private String[] keyword = {"From", "To", "Spam"};

    public void onReceive(Context context, Intent intent) {

        Object[] pdus = (Object[])intent.getExtras().get("pdus");
        SmsMessage shortMessage = SmsMessage.createFromPdu((byte[])pdus[0]);
        if(shortMessage.getDisplayMessageBody().equals(keyword)) {
            Toast.makeText(context, keyword.toString(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, keyword.toString(), Toast.LENGTH_LONG).show();
        }
        String body = shortMessage.getDisplayMessageBody().toLowerCase();

        boolean isAvailable = false;
        for(String word : keyword)
            if(body.contains(word.toLowerCase()))
                isAvailable = true;

        SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        for (SmsMessage sms : messages)
        {
            String message = sms.getMessageBody();
            String otp = message.split(": ")[1];
            editText1.setText(otp);

        }


    }
}