package com.pli;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	private static String displayName = "";
	private static Button room1;
	private static Button room2;
	private static Button room3;
	private static Button changeName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		room1 = (Button) findViewById(R.id.room1);
		room2 = (Button) findViewById(R.id.room2);
		room3 = (Button) findViewById(R.id.room3);
		changeName = (Button) findViewById(R.id.changeName);
		
		displayName = getIntent().getExtras().getString("Name");
		final Intent intent = new Intent(this, RoomActivity.class);
		
		room1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { 
            	intent.putExtra("Name", displayName);
            	intent.putExtra("Number", "Room1");
        		startActivity(intent);
            }
        });
		
		room2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	intent.putExtra("Name", displayName);
            	intent.putExtra("Number", "Room2");
        		startActivity(intent);
            }
        });
		
		room3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	intent.putExtra("Name", displayName);
            	intent.putExtra("Number", "Room3");
        		startActivity(intent);
            }
        });
		
		changeName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	final Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        		startActivity(intent);
        		finish();
            }
        });
	}
}
