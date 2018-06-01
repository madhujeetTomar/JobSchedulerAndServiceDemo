package com.mj.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;

public class MediaPlayerService extends Service {
    private static String TAG= MediaPlayerService.class.getSimpleName();
    MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: "+"Called");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mediaPlayer=MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

    return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        Log.d(TAG, "onDestroy: "+"called");
    }
}
