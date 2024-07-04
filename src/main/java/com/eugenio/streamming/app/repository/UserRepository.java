package com.eugenio.streamming.app.repository;

import com.eugenio.streamming.app.exception.FirestoreException;
import com.eugenio.streamming.app.model.user.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository class to User
 */
@Repository
public class UserRepository {
    private static final Logger log = LoggerFactory.getLogger(UserRepository.class);
    private static final String USER_COLLECTION = "users";
    private static final String USERNAME_FIELD = "username";

    private final Firestore db;

    public UserRepository(Firestore db) {
        this.db = db;
    }

    public User createUser(User user) {
        try {
            db.collection(USER_COLLECTION)
                    .add(user);
        } catch (Exception e) {
            log.error("Error to create user: {}", e.getMessage());
            throw new FirestoreException(e);
        }
        log.info("user created {}", user.toString());
        return user;
    }

    public User getUserByUsername(String username) {
        try {
            ApiFuture<QuerySnapshot> query = db.collection(USER_COLLECTION)
                    .whereEqualTo(USERNAME_FIELD, username)
                    .get();

            List<QueryDocumentSnapshot> queryDocumentSnapshots = query.get().getDocuments();

            return queryDocumentSnapshots.isEmpty() ? null :
                    queryDocumentSnapshots.stream().findFirst()
                            .get()
                            .toObject(User.class);

        } catch (Exception e) {
            log.error("Error to get user {}", e.getMessage());
            throw new FirestoreException(e);
        }
    }
}
