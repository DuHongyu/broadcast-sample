package com.example.broadcast.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

    private static final String TAG = "NetworkChangeReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "-------------222222222222");
        Toast.makeText(context, "network chang", Toast.LENGTH_SHORT).show();
        ConnectivityManager connectionManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {
            Log.d(TAG, "-------------111111111111");
            Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
        }
    }
}
