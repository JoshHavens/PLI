package com.pli;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class MainActivity extends Activity {
	private String displayName = "";
	private static Button room1;
	private static Button room2;
	private static Button room3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		room1 = (Button) findViewById(R.id.room1);
		room2 = (Button) findViewById(R.id.room2);
		room3 = (Button) findViewById(R.id.room3);
		final Intent intent = new Intent(this, RoomActivity.class);
		
		room1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   
            	intent.putExtra("Name", displayName);
            	intent.putExtra("Number", 1);
        		startActivity(intent);
            }
        });
		
		room2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	intent.putExtra("Name", displayName);
            	intent.putExtra("Number", 2);
        		startActivity(intent);
            }
        });
		
		room3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	intent.putExtra("Name", displayName);
            	intent.putExtra("Number", 3);
        		startActivity(intent);
            }
        });
		promptForName();
	}

	private void promptForName() {
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setTitle("Choose Name");
		alert.setMessage("Enter your display name below");
		final EditText input = new EditText(this);
		alert.setView(input);
		alert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				Editable value = input.getText();
				displayName = value.toString();
			}
			
		});
		alert.show();
	}
}
