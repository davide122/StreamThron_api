package com.project.streaming.runner;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import com.opencsv.bean.CsvToBeanBuilder;
import com.project.streaming.entity.ERole;
import com.project.streaming.entity.Role;
import com.project.streaming.enums.GenresMovie;
import com.project.streaming.model.Movies;
import com.project.streaming.payload.RegisterDto;
import com.project.streaming.repository.IMoviesRepository;
import com.project.streaming.repository.RoleRepository;
import com.project.streaming.repository.UserRepository;
import com.project.streaming.service.AuthService;
import com.project.streaming.service.AuthServiceImpl;


@Component
public class AuthRunner implements ApplicationRunner {
@Autowired AuthServiceImpl auth;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	AuthService authService;
	
	@Autowired IMoviesRepository moviesdb;
	private Set<Role> adminRole;
	private Set<Role> moderatorRole;
	private Set<Role> userRole;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");
		// Metodo da lanciare solo la prima volta
		// Serve per salvare i ruoli nel DB
//setRoleDefault();

//		createfilm();
//	createadmin();
		
	}

	private void setRoleDefault() {
		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);

		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);

		Role moderator = new Role();
		moderator.setRoleName(ERole.ROLE_MODERATOR);
		roleRepository.save(moderator);

	}

	
public void createadmin() {
	RegisterDto aadmin = new RegisterDto();
	Set<String> ruolo=new HashSet<String>();
	ruolo.add("ADMIN");
	ruolo.add("MODERATOR");
	ruolo.add("USER");
	aadmin.setEmail("newadmin");
	aadmin.setLastName("newadmin");
	aadmin.setName("newadmin");
	aadmin.setPassword("newadmin");
	aadmin.setRoles(ruolo);
	aadmin.setUsername("newadmin");
	auth.register(aadmin);
}

public void createfilm() {
	 List<String> actors = new ArrayList<>();
	    actors.add("Robert Downey Jr.");
	    actors.add("Chris Evans");
	    actors.add("Scarlett Johansson");
	Movies movie = new Movies();
	movie.setTitle("movies");
	movie.setActors(actors);
	movie.setDurata(180);
	movie.setAnno(1999);
	movie.setDescription("ciaondonidaonoidan");
	movie.setGeneri(GenresMovie.ACTION);
	movie.setPoster_url("www.gooogle.it");
	movie.setRating(8.8);
	movie.setTrailer_url("www.google.it");

	moviesdb.save(movie);
}


public void SetFavourites() {
	
}
}
