package com.eugenio.streamming.app.exception;

/**
 * Class to throw a exeption when error in firestore repositories
 */
public class FirestoreException extends RuntimeException{

    public FirestoreException(Exception e) {
        super(e);
    }
}
