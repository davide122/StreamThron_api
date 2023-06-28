package com.project.streaming.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.streaming.model.Movies;
import com.project.streaming.repository.IMoviesRepository;
import com.project.streaming.repository.RoleRepository;

@Service
public class MoviesService {
@Autowired IMoviesRepository Moviesdb;

public List<Movies> getAllMovies() {
    return Moviesdb.findAll();
}

public Optional<Movies> getMovieById(Long id) {
    return Moviesdb.findById(id);
}

public Movies createMovie(Movies movie) {
    return Moviesdb.save(movie);
}

public Movies updateMovie(Long id, Movies updatedMovie) {
    Optional<Movies> existingMovieOptional = Moviesdb.findById(id);

    if (existingMovieOptional.isPresent()) {
        Movies existingMovie = existingMovieOptional.get();
        existingMovie.setDescription(updatedMovie.getDescription());
        existingMovie.setAnno(updatedMovie.getAnno());
        existingMovie.setGeneri(updatedMovie.getGeneri());
        existingMovie.setDurata(updatedMovie.getDurata());
        existingMovie.setRating(updatedMovie.getRating());
        existingMovie.setActors(updatedMovie.getActors());
        existingMovie.setPosterurl(updatedMovie.getPosterurl());
        existingMovie.setTrailer(updatedMovie.getTrailer());

        return Moviesdb.save(existingMovie);
    } else {
        throw new IllegalArgumentException("Movie not found with ID: " + id);
    }
}

public void deleteMovie(Long id) {
	Moviesdb.deleteById(id);
}
}
