package com.autostart.bgo;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class NotificationReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent mainintent = new Intent(Intent.ACTION_MAIN);
        mainintent.addCategory(Intent.CATEGORY_LAUNCHER);
        ComponentName cn = new ComponentName("com.microvirt.launcher2", "com.microvirt.launcher.Launcher");
        mainintent.setComponent(cn);
        context.startActivity(mainintent);
    }
}


