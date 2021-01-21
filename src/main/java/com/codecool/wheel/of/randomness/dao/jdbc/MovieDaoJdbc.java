package com.codecool.wheel.of.randomness.dao.jdbc;

import com.codecool.wheel.of.randomness.dao.MovieDao;
import com.codecool.wheel.of.randomness.model.Movie;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MovieDaoJdbc implements MovieDao {
    private DataSource dataSource;
    private static final Logger logger = LoggerFactory.getLogger(MovieDaoJdbc.class);

    public MovieDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // TODO pass a random movie from this filtered list
    @Override
    public List<Movie> getAllMoviesByGenreId(int genreId) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT shows.id AS id, " +
                         "       shows.title AS title, " +
                         "       EXTRACT(YEAR from shows.year) AS \"year\", " +
                         "       shows.overview AS overview, " +
                         "       shows.runtime AS runtime, " +
                         "       shows.trailer AS trailer, " +
                         "       shows.homepage AS homepage, " +
                         "       round(shows.rating, 1) AS rating " +
                         "FROM shows " +
                         "JOIN show_genres ON shows.id = show_genres.show_id " +
                         "JOIN genres ON show_genres.genre_id = genres.id " +
                         "WHERE genres.id = ?" +
                         "GROUP BY shows.id";
            System.out.println(sql);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, genreId);
            ResultSet rs = statement.executeQuery();
            List<Movie> result = new ArrayList<>();
            while (rs.next()) {
                Movie movie = new Movie(rs.getInt(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getString(4),
                                        rs.getInt(5),
                                        rs.getString(6),
                                        rs.getString(7),
                                        rs.getDouble(8));
                result.add(movie);
            }
            logger.info("All movies loaded.");
            return result;
        } catch (SQLException e) {
            logger.warn("Cannot load all movies.");
            throw new RuntimeException("Error while reading all movies", e);
        }
    }

    @Override
    public Movie getRandomMovieByGenreId(int genreId) {
        List<Movie> movies = getAllMoviesByGenreId(genreId);
        Random rand = new Random();
        int randNum = rand.nextInt(movies.size());
        return movies.get(randNum);
    }

}
