package com.eugenio.streamming.app.repository;

import com.eugenio.streamming.app.exception.FirestoreException;
import com.eugenio.streamming.app.model.Movie;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class MovieRepository {

    private static final Logger log = LoggerFactory.getLogger(MovieRepository.class);
    private static final String MOVIES = "movies";
    private static final String NAME_FIELD = "name";
    private static final int TIMEOUT = 30;

    private final Firestore db;

    public MovieRepository(Firestore db) {
        this.db = db;
    }

    public Movie createMovie(Movie movie) {
        try {
            db.collection(MOVIES)
                    .add(movie);
        } catch (Exception e) {
            log.error("Error to create movie: {}", e.getMessage());
            throw new FirestoreException(e);
        }
        log.info("movie created: {}", movie.toString());
        return movie;
    }

    public Movie getMovieByName(String name) {
        try {
            ApiFuture<QuerySnapshot> query = db.collection(MOVIES)
                    .whereEqualTo(NAME_FIELD, name)
                    .get();
            QuerySnapshot queryDocumentSnapshot =
                    query.get(TIMEOUT, TimeUnit.SECONDS);
            List<QueryDocumentSnapshot> queryDocumentSnapshots = queryDocumentSnapshot.getDocuments();

            return queryDocumentSnapshots.isEmpty() ? null :
                    queryDocumentSnapshots.stream().findFirst()
                            .get()
                            .toObject(Movie.class);
        } catch (Exception e) {
            log.error("Error get movie: {}", e.getMessage());
            throw new FirestoreException(e);
        }
    }
}
