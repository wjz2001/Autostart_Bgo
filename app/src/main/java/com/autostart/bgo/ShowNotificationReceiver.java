package com.autostart.bgo;

import static android.content.Context.NOTIFICATION_SERVICE;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.util.Log;
import androidx.core.app.NotificationCompat;


public class ShowNotificationReceiver extends BroadcastReceiver{
    private static final String TAG = "RepeatReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "ShowNotificationReceiver onReceive");
        //设置点击通知栏的动作为启动另外一个广播
        Intent broadcastIntent = new Intent(context, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.
                getBroadcast(context, 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("启动逍遥桌面")
                .setTicker("可以启动逍遥桌面")
                .setOngoing(true)
                .setContentIntent(pendingIntent)
                .setSmallIcon(android.R.drawable.ic_lock_idle_charging);

        Log.i("repeat", "showNotification");
        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(2, builder.build());
    }
}


