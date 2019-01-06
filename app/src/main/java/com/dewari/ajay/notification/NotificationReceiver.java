package com.dewari.ajay.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra("message");
        String title = intent.getStringExtra("title");

        Toast.makeText(context, title, Toast.LENGTH_LONG).show();
    }
}
