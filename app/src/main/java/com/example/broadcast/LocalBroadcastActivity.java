package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.broadcast.broadcast.LocalReceiver;

public class LocalBroadcastActivity extends AppCompatActivity implements View.OnClickListener {

    private LocalReceiver localReceiver;

    private LocalBroadcastManager localBroadcastManager;

    private TextView textTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast);

        Button buttonLocalBroadcast = findViewById(R.id.buttonLocalBroadcast);
        buttonLocalBroadcast.setOnClickListener(this);

        textTwo = findViewById(R.id.textTwo);
        textTwo.setOnClickListener(this);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcast.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                super.onReceive(context, intent);
                textTwo.setText("you are baby");
            }
        };

        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent("com.example.broadcast.LOCAL_BROADCAST");
        localBroadcastManager.sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }
}