package com.niral.apiintegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niral.apiintegration.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
