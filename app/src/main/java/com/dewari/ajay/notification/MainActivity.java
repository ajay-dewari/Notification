package com.dewari.ajay.notification;


import android.app.Notification;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import static com.dewari.ajay.notification.NotificationApp.CHANNEL_1_ID;
import static com.dewari.ajay.notification.NotificationApp.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private EditText titleEditedText, messageEditedText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        notificationManager = NotificationManagerCompat.from(this);
        titleEditedText = findViewById(R.id.title);
        messageEditedText = findViewById(R.id.message);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sentNotificationOnChannel1(View v){
        String title = titleEditedText.getText().toString();
        String message = messageEditedText.getText().toString();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setAutoCancel(true).setSmallIcon(R.drawable.ic_chennal_1_beenhere)
                .setContentTitle(title).setContentText(message).setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_ALARM).build();

        notificationManager.notify(1, notification);
    }

    public void sentNotificationOnChannel2(View v){
        String title = titleEditedText.getText().toString();
        String message = messageEditedText.getText().toString();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setAutoCancel(true).setSmallIcon(R.drawable.ic_drafts_black_24dp)
                .setContentTitle(title).setContentText(message).setPriority(NotificationCompat.PRIORITY_LOW).build();

        notificationManager.notify(2, notification);
    }
}
