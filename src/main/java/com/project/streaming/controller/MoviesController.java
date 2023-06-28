package com.project.streaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.streaming.service.MoviesService;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/cliente")
public class MoviesController {
	
@Autowired MoviesService moviesservice;

@GetMapping("/all")
public ResponseEntity<?> getAllMovies(){
	return ResponseEntity.ok(moviesservice.getAllMovies());
}

@GetMapping("/{id}")
public ResponseEntity<?> getById(@PathVariable Long id) {
	return ResponseEntity.ok(moviesservice.getMovieById(id));
}

}
