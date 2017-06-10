package com.example.logonrm.androidwear;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public PendingIntent getPendingIntent(){
        // Build an intent for an action to open a url
        Intent urlIntent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("https://www.fiap.com.br/shift/curso/tecnologia/android-iot-wearables-cloud-computing");
        urlIntent.setData(uri);
        PendingIntent urlPendingIntent =
                PendingIntent.getActivity(this, 0, urlIntent, 0);
        return urlPendingIntent;
    }

    public void enviarNotificacao(View v){
        int notificationId = 101;
        // Build intent for notification content
        Intent viewIntent = new Intent(this, MainActivity.class);
        PendingIntent viewPendingIntent =
                PendingIntent.getActivity(this, 0, viewIntent, 0);
        //Building notification layout
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Fiap Shift")
                        .setContentText("Curso de Android IoT")
                        .addAction(R.mipmap.ic_launcher, "Abrir Fiap",
                                getPendingIntent())
                        .setContentIntent(viewPendingIntent);
        // instance of the NotificationManager service
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
        // Build the notification and notify it using notification manager.
        notificationManager.notify(notificationId, notificationBuilder.build());
    }
}
