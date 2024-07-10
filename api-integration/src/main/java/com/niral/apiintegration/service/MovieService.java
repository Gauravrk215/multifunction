package com.niral.apiintegration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.niral.apiintegration.model.Movie;
import com.niral.apiintegration.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private MovieRepository movieRepository;

	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	public void fetchAndStoreMovies(String apiUrl, String apiKey) {
		String url = apiUrl + "?api_key=" + apiKey;
		Movie[] movies = restTemplate.getForObject(url, Movie[].class);
		if (movies != null) {
			for (Movie movie : movies) {
				movieRepository.save(movie);
			}
		}
	}
}
