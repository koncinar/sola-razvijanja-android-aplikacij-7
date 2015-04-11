package com.comtrade.wear;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Toast;


public class WearableActionActivity extends ActionBarActivity {
    private static final String TAG = WearableActionActivity.class.getSimpleName();
    public static final String ACTION = "com.comtrade.wear.action.ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        Log.i(TAG, "Activity started");
    }
}
