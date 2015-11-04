package com.sourcebits.mediaplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements android.view.View.OnClickListener {
	Button startPlaybackButton, stopPlaybackButton;
	Intent Intent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		startPlaybackButton = (Button) this.findViewById(R.id.Start);
		stopPlaybackButton = (Button) this.findViewById(R.id.Stop);

		startPlaybackButton.setOnClickListener(this);
		stopPlaybackButton.setOnClickListener(this);

		Intent = new Intent(this, MediaplayerService.class);
	}

	public void onClick(View v) {
		if (v == startPlaybackButton) {
			startService(Intent);
			finish();
		} else if (v == stopPlaybackButton) {
			stopService(Intent);
			finish();
		}
	}

}
