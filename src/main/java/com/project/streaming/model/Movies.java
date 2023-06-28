package com.project.streaming.model;

import java.util.List;

import com.project.streaming.enums.GenresMovie;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	@Column(nullable = false)
private String description;
	@Column(nullable = false)
private Integer anno;
	@Column(nullable = false)
private GenresMovie generi;
	@Column(nullable = false)
private Integer durata;
private double rating;
@Column(nullable = false)
private List<String> actors;

@Column(nullable = false)
private String posterurl;

@Column(nullable = false)
private String Trailer;
}
