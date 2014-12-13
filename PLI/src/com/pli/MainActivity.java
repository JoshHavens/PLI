package com.pli;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class MainActivity extends Activity {
	private static String displayName;
	private static Intent intent;
	private static FirebaseDatabase database;
	private static Bundle main = new Bundle();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		displayName = getIntent().getExtras().getString("Name");
		intent = new Intent(this, RockPaperScissors.class);
		main.putString("Name", displayName);
	}
	
	public void clickRoom1(View view) {
		main.putString("Room", "Room1");
    	database = new FirebaseDatabase(this, "Room1");
    	if (database.roomFull()) {
    		alertRoomFull();
		} else {
			intent.putExtras(main);
			startActivity(intent);
		}
	}
	
	public void clickRoom2(View view) {
		main.putString("Room", "Room2");
    	database = new FirebaseDatabase(this, "Room2");
    	if (database.roomFull()) {
    		alertRoomFull();
		} else {
			intent.putExtras(main);
			startActivity(intent);
		}
	}
	
	public void clickRoom3(View view) {
		main.putString("Room", "Room3");
    	database = new FirebaseDatabase(this, "Room3");
    	if (database.roomFull()) {
    		alertRoomFull();
		} else {
			intent.putExtras(main);
			startActivity(intent);
		}
	}
	
	public void clickChangeName(View view) {
		final Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
		startActivity(intent);
	}
	
	private void alertRoomFull() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Oops! This room is full.")
		       .setCancelable(false)
		       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		                //do things
		           }
		       });
		AlertDialog alert = builder.create();
		alert.show();
	}
}
