package com.autostart.bgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, PushService.class);
        startService(intent);
        setTitle("MainActivity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        ComponentName cn = new ComponentName("com.bilibili.fatego", "com.bilibili.fatego.EmptyClass");
        intent.setComponent(cn);
        startActivity(intent);
    }

}


