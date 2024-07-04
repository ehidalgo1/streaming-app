package com.eugenio.streamming.app.controller;

import com.eugenio.streamming.app.model.Movie;
import com.eugenio.streamming.app.model.common.Response;
import com.eugenio.streamming.app.service.MovieService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(
            value = "movies",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getMovies() {
        return null;
    }

    @PostMapping(
            value = "movie",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Response> createMovie(@RequestBody Movie movie) {
        Response response = movieService.createMovie(movie);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

}
