package com.wheel.of.randomness.dao.jdbc.test;

import com.codecool.wheel.of.randomness.config.DataManager;
import com.codecool.wheel.of.randomness.dao.jdbc.GenreDaoJdbc;
import com.codecool.wheel.of.randomness.model.Genre;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GenreDaoJdbcTest {
    GenreDaoJdbc testJDBC = new GenreDaoJdbc(DataManager.connectDataBase());


    @Test
    void getAll_ReturnsAllRowsFromDb() {
        int genreTableSize = 21;
        List<Genre> allGenre = testJDBC.getAll();
        assertEquals(genreTableSize, allGenre.size());
    }


}
