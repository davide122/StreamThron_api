package com.project.streaming.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.streaming.enums.GenresMovie;
import com.project.streaming.model.Movies;

@Repository
public interface IMoviesRepository  extends JpaRepository<Movies, Long> {
	List<Movies> findByTitleContainingIgnoreCase(String titolo);

}