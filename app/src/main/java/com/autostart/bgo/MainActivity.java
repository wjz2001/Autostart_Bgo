package com.autostart.bgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.content.pm.PackageManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String PACKAGE_NAME = "com.bilibili.fatego";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, PushService.class);
        startService(intent);
        setTitle("MainActivity");
        launchBgo();
    }

    private void launchBgo() {
        PackageManager packageManager = getPackageManager();
        Intent launchIntent = packageManager.getLaunchIntentForPackage(PACKAGE_NAME);

        if (launchIntent != null) {
            startActivity(launchIntent);
        } else {
            Toast.makeText(this, "命运·冠位指定未安装", Toast.LENGTH_SHORT).show();
        }
    }
}

