package com.eugenio.streamming.app.service;

import com.eugenio.streamming.app.dto.MovieDTO;
import com.eugenio.streamming.app.model.Movie;
import com.eugenio.streamming.app.model.common.Response;
import com.eugenio.streamming.app.repository.MovieRepository;
import com.google.cloud.Timestamp;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private static final Logger log = LoggerFactory.getLogger(MovieService.class);
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    public MovieService(MovieRepository movieRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

    public Response createMovie(Movie movie) {
        try {
            if (movieRepository.getMovieByName(movie.getName()) != null) {
                return Response.builder()
                        .code(400)
                        .errors(List.of("La pelicula ya existe"))
                        .build();
            }
            movie.setCreateAt(Timestamp.now());
            return Response.builder()
                    .code(201)
                    .payload(modelMapper
                            .map(movieRepository.createMovie(movie),
                                    MovieDTO.class)
                    )
                    .build();
        } catch (Exception e) {
            log.error("Error to create movie: {}", e.getMessage());
            return Response.builder()
                    .code(500)
                    .errors(List.of("error to create movie"))
                    .build();
        }
    }

    public List<Movie> getMovies(int limit) {
        return movieRepository.getMovies(limit);
    }
}
