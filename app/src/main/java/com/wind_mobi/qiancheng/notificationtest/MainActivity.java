package com.wind_mobi.qiancheng.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.io.File;

import static com.wind_mobi.qiancheng.notificationtest.R.drawable.wonderful;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button sendNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotification = (Button) findViewById(R.id.send_notification);
        sendNotification.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send_notification:
                Uri soundUri = Uri.fromFile(new File("/system/media/audio/ringtones/TechnoRing.ogg"));
                long[] vibrates = {0, 1000, 1000, 1000};
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new Notification(R.drawable.wonferf, "this is sticker text", System.currentTimeMillis());
                notification.sound = soundUri;
                notification.vibrate = vibrates;
                Intent intent = new Intent(this, com.wind_mobi.qiancheng.notificationtest.Notification.class);
                PendingIntent pi = PendingIntent.getActivities(this, 0, new Intent[]{intent}, PendingIntent.FLAG_CANCEL_CURRENT);
                notification.setLatestEventInfo(this, "YY yuyin", "this is YY yuyin sen for u", pi);
                manager.notify(1,notification);
                manager.cancel(1);
                break;
            default:
                break;

        }
    }
}