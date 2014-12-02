package com.pli;

import com.firebase.client.Firebase;
import com.google.api.client.json.Json;

public class FirebaseAPI {
	private static final String url = "https://pli-kley.firebaseio.com/";
	private static volatile Firebase firebase = null;
	
	private FirebaseAPI() {}
	
	public static Firebase getInstance() {
		if (firebase == null) {
            firebase = new Firebase(url);
        }
        return firebase;
	}
	
	public void write(Json message) {
		firebase.setValue(message);
	}
	
	public void write(String child, Json message) {
		firebase.child(child).setValue(message);
	}
	
	public void changeRoom(String room) {
		firebase = new Firebase(url + room);
	} 
}
