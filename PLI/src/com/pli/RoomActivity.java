package com.pli;

import com.firebase.client.Firebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class RoomActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Firebase.setAndroidContext(this);
		Firebase myFirebaseRef = FirebaseAPI.getInstance();
		
		
		
	}
	
	
}