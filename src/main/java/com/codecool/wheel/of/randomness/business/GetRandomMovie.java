package com.codecool.wheel.of.randomness.business;

import com.codecool.wheel.of.randomness.config.DataManager;
import com.codecool.wheel.of.randomness.dao.MovieDao;
import com.codecool.wheel.of.randomness.dao.jdbc.MovieDaoJdbc;
import com.codecool.wheel.of.randomness.model.Movie;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/random-show"})
public class GetRandomMovie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json"); resp.setCharacterEncoding("UTF-8");

        int genreId = Integer.parseInt(req.getParameter("genre-id"));

        MovieDao movieDao = new MovieDaoJdbc(DataManager.connectDataBase());
        Movie movie = movieDao.getRandomMovieByGenreId(genreId);

        PrintWriter out = resp.getWriter();

        JSONObject responseJson = new JSONObject();
        responseJson.put("id", movie.getId());
        responseJson.put("title", movie.getTitle());
        responseJson.put("year", movie.getDate());
        responseJson.put("overview", movie.getOverView());
        responseJson.put("runtime", movie.getRunTime());
        responseJson.put("trailer", movie.getTrailerUrl());
        responseJson.put("homepage", movie.getHomePageUrl());
        responseJson.put("rating", movie.getRating());
        //TODO "google" an image by title and returns the url as json

        String response = responseJson.toJSONString();

        out.println(response);
    }
}