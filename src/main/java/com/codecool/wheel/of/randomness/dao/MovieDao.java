package com.codecool.wheel.of.randomness.dao;

import com.codecool.wheel.of.randomness.model.Genre;
import com.codecool.wheel.of.randomness.model.Movie;

import java.util.List;

public interface MovieDao {

    List<Movie> getAllMoviesByGenreId(int genreId);
}
