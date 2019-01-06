package com.dewari.ajay.notification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class NotificationApp extends Application {

    public final static String CHANNEL_1_ID = "channel_1";
    public final static String CHANNEL_2_ID = "channel_2";
    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();
    }

    public void createNotificationChannels(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel1 = new NotificationChannel(CHANNEL_1_ID,
                    "Channel Name 1", NotificationManager.IMPORTANCE_HIGH);

            notificationChannel1.setDescription("This is channel 1 used for...");
            notificationChannel1.enableVibration(true);
            notificationChannel1.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});

            NotificationChannel notificationChannel2= new NotificationChannel(CHANNEL_2_ID,
                    "Channel Name 2", NotificationManager.IMPORTANCE_LOW);
            notificationChannel2.setDescription("This is channel 1 used for...");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notificationChannel1);
        }
    }
}
