package com.easyturn.storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.internal.FirebaseAppStore;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;



public class firebase {
	private static final String DATABASE_URL = "https://easyturn-efa19.firebaseio.com/";
	
	
	
	public static void main(String[] args) throws IOException {
		DatabaseReference database;
		database = FirebaseDatabase.getInstance().getReference();
		try {
			FileInputStream refreshToken = new FileInputStream("easyturn-efa19-firebase-adminsdk.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
			    .setCredentials(GoogleCredentials.fromStream(refreshToken))
			    .setDatabaseUrl(DATABASE_URL)
			    .build();

			FirebaseApp.initializeApp(options);
			//System.out.println(database.getDatabase().toString());
		} catch (Exception e) {
			System.out.println("ERROR: invalid service account credentials. See README.");
            System.out.println(e.getMessage());
		}
		
		
		
		
		
	}
	
	
}

