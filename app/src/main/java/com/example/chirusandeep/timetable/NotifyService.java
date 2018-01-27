package com.example.chirusandeep.timetable;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

public class NotifyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String notificationTitle = "Demo of Notification!";
        String notificationText = "Test";

        Intent resultIntent = new Intent(this, HelloWorldActivity.class);
        resultIntent.putExtra("userName", "Sundeep");

        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this, "007")
                        .setSmallIcon(R.drawable.white_icon)
                        .setContentTitle(notificationTitle)
                        .setContentText(notificationText)
                        .setContentIntent(resultPendingIntent);

        int mNotificationId = 10;
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId, mBuilder.build());

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
