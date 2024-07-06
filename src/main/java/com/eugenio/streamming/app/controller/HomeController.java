package com.eugenio.streamming.app.controller;

import com.eugenio.streamming.app.model.Movie;
import com.eugenio.streamming.app.service.MovieService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class controller home to show movies
 * and principal page
 */
@RestController
@RequestMapping("/")
public class HomeController {

    private final MovieService movieService;

    public HomeController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(
            value = "",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Movie>> getHome(
            @RequestParam(required = false) String limit) {
        return ResponseEntity.ok(
                movieService.getMovies(Integer.parseInt(limit))
        );
    }
}
