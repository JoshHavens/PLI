package com.pli;

import java.util.HashMap;
import java.util.Map;
import android.content.Context;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class FirebaseDatabase implements DatabaseAdapter {
	private static final String url = "https://pli-kley.firebaseio.com/";
	private static Firebase firebase;
	Map<String, Object> user = new HashMap<String, Object>();

	public FirebaseDatabase(Context context, String room, String displayName) {
		Firebase.setAndroidContext(context);
		firebase = new Firebase(url + room + "/Users/").push();
		user.put("Name", displayName);
		user.put("Selection", "");
		user.put("Score", "");
		firebase.updateChildren(user);
	} 

	public void sendSelection(String selection) {
		user.put("Selection", selection);
		firebase.updateChildren(user);
	}

	public void remove() {
		firebase.removeValue();
	}
	
	private Boolean newUser(String displayName) {
		firebase.child("Game").addListenerForSingleValueEvent(new ValueEventListener() {
		    @Override
		    public void onDataChange(DataSnapshot snapshot) {
		        // do some stuff once
		    }
		    @Override
		    public void onCancelled(FirebaseError firebaseError) {
		    }
		});
		return true;
	}
}
