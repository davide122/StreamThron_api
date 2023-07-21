package com.project.streaming.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.streaming.enums.GenresMovie;
import com.project.streaming.model.Movies;
import com.project.streaming.repository.IMoviesRepository;
import com.project.streaming.repository.RoleRepository;

import jakarta.persistence.EntityNotFoundException;

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
        existingMovie.setTitle(updatedMovie.getTitle());
        existingMovie.setDescription(updatedMovie.getDescription());
        existingMovie.setAnno(updatedMovie.getAnno());
        existingMovie.setGeneri(updatedMovie.getGeneri());
        existingMovie.setDurata(updatedMovie.getDurata());
        existingMovie.setRating(updatedMovie.getRating());
        existingMovie.setActors(updatedMovie.getActors());
        existingMovie.setPoster_url(updatedMovie.getPoster_url());
        existingMovie.setTrailer_url(updatedMovie.getTrailer_url());
        existingMovie.setText_png_url(updatedMovie.getText_png_url());

        return Moviesdb.save(existingMovie);
    } else {
        throw new IllegalArgumentException("Movie not found with ID: " + id);
    }
}

//Cancellazione film
public String deleteMovie(Long id){
	if(!Moviesdb.existsById(id)) {
		throw new EntityNotFoundException("film non esiste");
	}
	Moviesdb.deleteById(id);
	return "film Cancellato";
}


//Modifica film
public Optional<?> putMovies(Movies movie, long id) {
	if(!Moviesdb.existsById(id)) {
		throw new EntityNotFoundException("FIlm non esiste");
	}else {
		return Optional.of(Moviesdb.save(movie));
	}
}



}
