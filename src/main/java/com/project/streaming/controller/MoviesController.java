package com.project.streaming.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.streaming.entity.User;
import com.project.streaming.enums.GenresMovie;
import com.project.streaming.model.Movies;
import com.project.streaming.repository.IMoviesRepository;
import com.project.streaming.repository.UserRepository;
import com.project.streaming.service.MoviesService;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/film")
public class MoviesController {
	
@Autowired MoviesService moviesservice;
@Autowired IMoviesRepository moviedb;
@Autowired UserRepository userdb;
@GetMapping("/all")
public ResponseEntity<?> getAllMovies(){
	System.out.println("ciao");
	return ResponseEntity.ok(moviesservice.getAllMovies());
	
}

@GetMapping("/{id}")
public ResponseEntity<?> getById(@PathVariable Long id) {
	return ResponseEntity.ok(moviesservice.getMovieById(id));
}

@PostMapping
public ResponseEntity<?> save(@RequestBody Movies movie) {
	return ResponseEntity.ok(moviesservice.createMovie(movie));
}

@PutMapping("/{id}")
public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Movies movie) {
	return ResponseEntity.ok(moviesservice.putMovies(movie, id));
}

@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable long id) {
	return ResponseEntity.ok(moviesservice.deleteMovie(id));
}


//{
//    "description": "ciaondongfgfidaonFoidan",
//    "name": "movieFs",
//    "anno": 1999,
//    "generi": "ACTION",
//    "durata": 180,
//    "rating": 8.8,
//    "actors": [
//        "Robert Downey Jr.",
//        "Chris Evans",
//        "Scarlett Johansson"
//    ],
//    "poster_url": "www.goooOgle.it",
//    "trailer_url": "www.goOogle.it"
//}

}
