package com.project.streaming.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.streaming.model.Movies;

@Repository
public interface IMoviesRepository  extends JpaRepository<Movies, Long> {


}