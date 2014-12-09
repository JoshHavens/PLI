package com.pli;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	private static String displayName;
	private static Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		displayName = getIntent().getExtras().getString("Name");
		intent = new Intent(this, RockPaperScissors.class);
		intent.putExtra("Name", displayName);
	}
	
	public void clickRoom1(View view) {
    	intent.putExtra("Room", "Room1");
		startActivity(intent);
	}
	
	public void clickRoom2(View view) {
    	intent.putExtra("Room", "Room2");
		startActivity(intent);
	}
	
	public void clickRoom3(View view) {
    	intent.putExtra("Room", "Room3");
		startActivity(intent);
	}
	
	public void clickChangeName(View view) {
		final Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
		startActivity(intent);
	}
}
