package com.niral.apiintegration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niral.apiintegration.model.Movie;
import com.niral.apiintegration.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping("/fetch")
    public void fetchAndStoreMovies(@RequestParam String apiUrl, @RequestParam String apiKey) {
        movieService.fetchAndStoreMovies(apiUrl, apiKey);
    }
}
