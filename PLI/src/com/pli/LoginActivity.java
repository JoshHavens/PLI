package com.pli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		final Intent intent = new Intent(this, MainActivity.class);
		
		final EditText input = (EditText) findViewById(R.id.displayName);
		Button login = (Button) findViewById(R.id.login);
		
		login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	String displayName = input.getText().toString();
            	if (displayName.trim().length() > 0) {
            		intent.putExtra("Name", displayName);
            		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            		startActivity(intent);
				}
            }
        });
	}	
}
