package com.comtrade.wear;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


public class WearableActionBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = WearableActionBroadcastReceiver.class.getSimpleName();
    public static final String ACTION = "com.comtrade.wear.ACTION_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !ACTION.equals(intent.getAction())) {
            return;
        }

        Log.i(TAG, "Broadcast received");
    }
}