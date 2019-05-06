package com.easyturn.storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.api.core.ApiFuture;
import com.google.api.services.storage.Storage.BucketAccessControls.List;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.Path;
import com.google.firebase.internal.FirebaseAppStore;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.v1beta1.FirestoreClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class firebase {
	private static final String DATABASE_URL = "https://easyturn-efa19.firebaseio.com/";

	@Autowired
	public static void main(String[] args) throws IOException {

		try {
			InputStream serviceAccount = new FileInputStream("easyturn-efa19-firebase-adminsdk.json");
			GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
			FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(credentials).build();
			FirebaseApp.initializeApp(options);

			Firestore db = com.google.firebase.cloud.FirestoreClient.getFirestore();

			ApiFuture<QuerySnapshot> query = db.collection("usuarios").get();

			// ...
			// query.get() blocks on response
			QuerySnapshot querySnapshot = query.get();
			java.util.List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
			for (QueryDocumentSnapshot document : documents) {
				System.out.println("email: " + document.getString("email"));

			}

		} catch (Exception e) {
			System.out.println("ERROR: invalid service account credentials. See README.");
			System.out.println(e.getMessage());
		}

	}

}