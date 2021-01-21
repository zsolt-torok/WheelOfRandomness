package com.wheel.of.randomness.dao.jdbc.test;

import com.codecool.wheel.of.randomness.config.DataManager;
import com.codecool.wheel.of.randomness.dao.jdbc.MovieDaoJdbc;
import com.codecool.wheel.of.randomness.model.Movie;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieDaoJdbcTest {
    MovieDaoJdbc testJDBC = new MovieDaoJdbc(DataManager.connectDataBase());


    @Test
    void getRandomMovieByValidGenreId_shouldReturnMovie() {
        int id = 1;
        assertTrue(testJDBC.getRandomMovieByGenreId(id) instanceof Movie);
    }


    @Test
    void getRandomMovieByNotExistingGenreId_shouldReturnNull() {
        int id = 40;
        assertEquals(testJDBC.getRandomMovieByGenreId(id), null);
    }

    @Test
    void getRandomMovieByNegativeGenreId_shouldReturnNull() {
        int id = -1;
        assertEquals(testJDBC.getRandomMovieByGenreId(id), null);
    }


    @Test
    void getRandomMovieByGenreId_shouldReturnOneMovie() {
        int id = 1;
        List<Movie> arr = new ArrayList<>();
        arr.add(testJDBC.getRandomMovieByGenreId(id));
        assertEquals(arr.size(), 1);
    }

    @Test
    void getAll_ReturnsAllRowsFromDb() {
        int showTableSize = 262;
        int genreId = 1;
        List<Movie> allMovie = testJDBC.getAllMoviesByGenreId(genreId);
        assertEquals(showTableSize, allMovie.size());
    }

}
