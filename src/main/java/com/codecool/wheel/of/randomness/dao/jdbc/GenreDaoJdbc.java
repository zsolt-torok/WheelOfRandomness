package com.codecool.wheel.of.randomness.dao.jdbc;

import com.codecool.wheel.of.randomness.dao.GenreDao;
import com.codecool.wheel.of.randomness.model.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDaoJdbc implements GenreDao {
    private DataSource dataSource;
    private static final Logger logger = LoggerFactory.getLogger(MovieDaoJdbc.class);

    public GenreDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Genre> getAll() {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT name FROM genres";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            List<Genre> result = new ArrayList<>();
            while (rs.next()) {
                Genre genres = new Genre(rs.getInt(1), rs.getString(2));
                result.add(genres);
            }
            logger.info("All genres loaded.");
            return result;
        } catch (SQLException e) {
            logger.warn("Cannot load all movie genres.");
            throw new RuntimeException("Error while reading all movie genres", e);
        }

    }
}
