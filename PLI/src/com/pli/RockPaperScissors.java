package com.pli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RockPaperScissors extends Activity {
	private String displayName;
	private String room;
	private FirebaseDatabase database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rockpaperscissors);
		displayName = getIntent().getExtras().getString("Name");
		room = getIntent().getExtras().getString("Room");
		database = new FirebaseDatabase(this, room, displayName);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		database.remove();
	};

	public void clickRock(View view) {
		database.sendSelection("Rock");
	}

	public void clickPaper(View view) {
		database.sendSelection("Paper");
	}

	public void clickScissors(View view) {
		database.sendSelection("Scissors");
	}
	
	public void clickExit(View view) {
		final Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		database.remove();
		intent.putExtra("Name", displayName);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
		finish();
	}
}