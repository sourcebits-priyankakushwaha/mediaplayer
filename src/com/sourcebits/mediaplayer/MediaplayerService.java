package com.sourcebits.mediaplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MediaplayerService extends Service implements MediaPlayer.OnCompletionListener {
	  MediaPlayer mediaPlayer;

	  @Override
	  public IBinder onBind(Intent intent) {
	    return null;
	  }

	  @Override
	  public void onCreate() {
	    mediaPlayer = MediaPlayer.create(this, R.raw.song2);
	    mediaPlayer.setOnCompletionListener(this);
	  }

	  @Override
	  public int onStartCommand(Intent intent, int flags, int startId) {
	    if (!mediaPlayer.isPlaying()) {
	      mediaPlayer.start();
	    }
	    return START_STICKY;
	  }

	  public void onDestroy() {
	    if (mediaPlayer.isPlaying()) {
	      mediaPlayer.stop();
	    }
	    mediaPlayer.release();
	  }

	  public void onCompletion(MediaPlayer _mediaPlayer) {
	    stopSelf();
	  }

	}