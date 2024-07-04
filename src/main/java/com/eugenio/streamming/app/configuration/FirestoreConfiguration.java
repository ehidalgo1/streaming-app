package com.eugenio.streamming.app.configuration;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirestoreConfiguration {

    @Value("${firebase.credential.path}")
    private String credentialPath;

    @Bean
    public FirebaseApp initializeFirestore() throws IOException {
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setProjectId("<FIREBASE_PROJECT_ID>")
                .build();

        return FirebaseApp.initializeApp(options);
    }

    @Bean
    public Firestore firestore() throws IOException {
        Credentials credentials = GoogleCredentials.getApplicationDefault();

        return FirestoreOptions.newBuilder()
                .setCredentials(credentials)
                .build()
                .getService();
    }
}
