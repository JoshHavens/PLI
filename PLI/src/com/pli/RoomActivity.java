package com.pli;

import com.firebase.client.Firebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RoomActivity extends Activity {
	private String displayName;
	private String number;
	private static Button rock;
	private static Button paper;
	private static Button scissors;
	private static Button exit;
	private static final String url = "https://pli-kley.firebaseio.com/";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_room);
		Firebase.setAndroidContext(this);
		displayName = getIntent().getExtras().getString("Name");
		number = getIntent().getExtras().getString("Number");
		final Firebase myFirebaseRef = new Firebase(url + number);
		myFirebaseRef.child("Users").child("4").child("Name").setValue(displayName);	
		
		final Intent intent = new Intent(this, MainActivity.class);
		
		rock = (Button) findViewById(R.id.rock);
		paper = (Button) findViewById(R.id.paper);
		scissors = (Button) findViewById(R.id.scissors);
		exit = (Button) findViewById(R.id.exit);
		
		rock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   
            	myFirebaseRef.child("Users")
            				.child("4")
            				.child("Selection")
            				.setValue("Rock");
            }
        });
		
		paper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   
            	myFirebaseRef.child("Users")
            				.child("4")
            				.child("Selection")
            				.setValue("Paper");
            }
        });
		
		scissors.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   
            	myFirebaseRef.child("Users")
            				.child("4")
            				.child("Selection")
            				.setValue("Scissors");
            }
        });
		
		exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
            	myFirebaseRef.child("Users").child("4").removeValue();
            	startActivity(intent);
            }
        });
		
	}	
}