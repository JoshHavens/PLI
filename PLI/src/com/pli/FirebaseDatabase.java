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
	private static long present = 0;
	private static long capacity = 0;
	private static Map<String, Object> user = new HashMap<String, Object>();

	public FirebaseDatabase(Context context, String room) {
		Firebase.setAndroidContext(context);
		firebase = new Firebase(url + room);
	}
	
	public FirebaseDatabase(Context context, String room, String displayName) {
		Firebase.setAndroidContext(context);
		firebase = new Firebase(url + room + "/Users/").push();
		user.put("Name", displayName);
		user.put("Score", null);
		user.put("Selection", null);
		firebase.updateChildren(user);	
	}

	public void sendSelection(String selection) {
		user.put("Selection", selection);
		firebase.updateChildren(user);
	}

	public void remove() {
		firebase.removeValue();
	}

	public Boolean roomFull() {
		firebase.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				present = snapshot.child("Users").getChildrenCount();
				capacity = (long) snapshot.child("Capacity").getValue();
			}
			@Override
			public void onCancelled(FirebaseError firebaseError) {
				 System.out.println("The read failed: " + firebaseError.getMessage());
			}
		});
		if (present == capacity) {
			return true;
		}
		return false;
	}
}
