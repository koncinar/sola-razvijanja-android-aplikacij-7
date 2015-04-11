package com.comtrade.wear;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class WearableActionService extends IntentService {
    private static final String TAG = WearableActionService.class.getSimpleName();
    public static final String ACTION = "com.comtrade.wear.action.SERVICE";


    public WearableActionService() {
        super("WearableIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent == null || !ACTION.equals(intent.getAction())) {
            return;
        }

        Log.i(TAG, "Service started");
    }
}
