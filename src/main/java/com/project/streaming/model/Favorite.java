package com.project.streaming.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.streaming.entity.Role;
import com.project.streaming.entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne()
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne()
    @JoinColumn(name = "movie_id")
    private Movies movie;
    
    
}