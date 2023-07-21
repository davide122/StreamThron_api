package com.project.streaming.model;

import java.util.List;
import java.util.Set;

import com.project.streaming.entity.User;
import com.project.streaming.enums.GenresMovie;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "movies")
public class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	  @Column(nullable = false, length = 100000000)
private String description;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
private Integer anno;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
private GenresMovie generi;
	@Column(nullable = false)
private Integer durata;
private double rating;
@Column()
private List<String> actors;

@Column(nullable = false, length = 100000000)
private String poster_url;
@Column(nullable = false, length = 100000000)
private String Trailer_url;

@Column(length = 100000000)
private String text_png_url;


}

