package com.project.streaming.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.streaming.entity.User;
import com.project.streaming.model.Favorite;
import com.project.streaming.model.Movies;
import com.project.streaming.repository.IFavouritesRepository;
import com.project.streaming.repository.IMoviesRepository;
import com.project.streaming.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional; 

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/favorites/film")
public class FavouritesController {

    @Autowired
    private IFavouritesRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IMoviesRepository movieRepository;

    @PostMapping("/{movieId}")
    @Transactional
    public List<Favorite> addMovieToFavorites(@PathVariable Long movieId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
        		
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        System.out.println(username);

        Movies movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));

        boolean isMovieAlreadyFavorited = user.getFavorites().stream()
                .anyMatch(favorite -> favorite.getMovie().getId().equals(movieId));
        
        if (isMovieAlreadyFavorited) {
            // Gestisci l'aggiunta duplicata a tua discrezione
            // Ad esempio, puoi restituire un messaggio di errore o ignorare l'aggiunta duplicata
            System.out.println("Il film è già presente nei preferiti dell'utente");
            return user.getFavorites();
        }
        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setMovie(movie);

        user.getFavorites().add(favorite);
        userRepository.save(user);

        // Carica i dettagli del film associato a ogni preferito
        List<Favorite> favorites = user.getFavorites();
        favorites.forEach(fav -> {
            Movies favMovie = fav.getMovie();
            
            
        });
return favorites;
     

           
    }


    @DeleteMapping("/{favoriteId}")
    public void removeFavorite(@PathVariable Long favoriteId) {
        Favorite favorite = favoriteRepository.findById(favoriteId)
                .orElseThrow(() -> new EntityNotFoundException("Favorite not found"));

        // Rimuovi il riferimento al favorito dall'utente senza eliminare il film associato
        User user = favorite.getUser();
        user.getFavorites().remove(favorite);
        userRepository.save(user);

        // Elimina il favorito
        favoriteRepository.delete(favorite);
    }
    

    @GetMapping("/all")
    public List<Favorite> getAllFavorites() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        return user.getFavorites();
    }


}
