package com.eugenio.streamming.app.service;

import com.eugenio.streamming.app.dto.MovieDTO;
import com.eugenio.streamming.app.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class service to Home
 */
@Service
public class HomeService {

    private final MovieService movieService;

    public HomeService(MovieService movieService) {
        this.movieService = movieService;
    }

    public List<Movie> showMoviesHome(int limit) {
        return movieService.getMovies(limit);
    }
}
