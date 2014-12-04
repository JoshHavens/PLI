package com.pli;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

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
	private static Boolean startRound;
	private static final String url = "https://pli-kley.firebaseio.com/";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_room);
		Firebase.setAndroidContext(this);
		displayName = getIntent().getExtras().getString("Name");
		number = getIntent().getExtras().getString("Number");
		final Firebase myFirebaseRef = new Firebase(url + number + "/Users/");
		myFirebaseRef.child(displayName + "/Selection").setValue("");
		final Intent intent = new Intent(this, MainActivity.class);
		
		rock = (Button) findViewById(R.id.rock);
		paper = (Button) findViewById(R.id.paper);
		scissors = (Button) findViewById(R.id.scissors);
		exit = (Button) findViewById(R.id.exit);
		
		myFirebaseRef.child("startRound").addValueEventListener(new ValueEventListener() {

			  @Override
			  public void onDataChange(DataSnapshot snapshot) {
			    System.out.println(snapshot.getValue());
			  }

			  @Override public void onCancelled(FirebaseError error) { }

		});
		
		rock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   
            	myFirebaseRef.child(displayName + "/Selection")
            				.setValue("Rock");
            }
        });
		
		paper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   
            	myFirebaseRef.child(displayName + "/Selection")
            				.setValue("Paper");
            }
        });
		
		scissors.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   
            	myFirebaseRef.child(displayName + "/Selection")
            				.setValue("Scissors");
            }
        });

		exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	if (!startRound) {
            		myFirebaseRef.child(displayName).removeValue();
                	intent.putExtra("Name", displayName);
                	startActivity(intent);
                	finish();
				}
            }
        });
	}	
}