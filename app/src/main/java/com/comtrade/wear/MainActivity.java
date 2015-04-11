package com.comtrade.wear;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.btn_show_notification)
    public void showNotification() {
        Log.i(TAG, "Showing notification");

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.bg_wearable))
                .setContentTitle(getString(R.string.notification_title))
                .setContentText(getString(R.string.notification_message))
                .addAction(getActivityAction())
                .addAction(getServiceAction())
                .addAction(getBroadcastAction());
        NotificationManagerCompat.from(this).notify(NOTIFICATION_ID, notificationBuilder.build());
    }

    private NotificationCompat.Action getActivityAction() {
        Intent intent = new Intent(this, WearableActionActivity.class);
        intent.setAction(WearableActionActivity.ACTION);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        return new NotificationCompat.Action(R.drawable.ic_action_star, getString(R.string.action_start_activity), pendingIntent);
    }

    private NotificationCompat.Action getServiceAction() {
        Intent intent = new Intent(this, WearableActionService.class);
        intent.setAction(WearableActionService.ACTION);
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent, 0);
        return new NotificationCompat.Action(R.drawable.ic_action_done, getString(R.string.action_start_service), pendingIntent);
    }

    private NotificationCompat.Action getBroadcastAction() {
        Intent intent = new Intent();
        intent.setAction(WearableActionBroadcastReceiver.ACTION);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        return new NotificationCompat.Action(R.drawable.ic_action_call, getString(R.string.action_start_broadcast), pendingIntent);
    }

}
