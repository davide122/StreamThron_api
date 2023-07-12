package com.project.streaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.streaming.entity.User;
import com.project.streaming.model.Favorite;

import java.util.List;

@Repository
public interface IFavouritesRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUser(User user);
    
}
