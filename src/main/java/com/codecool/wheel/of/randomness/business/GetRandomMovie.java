package com.codecool.wheel.of.randomness.business;

import com.codecool.wheel.of.randomness.model.Movie;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/movies"})
public class GetRandomMovie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Movie movie = new Movie();
        //TODO implement class to initialize values for 'movie' by randomly (by genre) selected show data from db

        PrintWriter out = resp.getWriter();
        /*
        JSONObject responseJson = new JSONObject();
        responseJson.put("title", movie.getTitle());
        responseJson.put("year", movie.getYear());
        responseJson.put("overview", movie.getOverview());
        responseJson.put("runtime", movie.getRuntime());
        responseJson.put("trailer", movie.getTrailer());
        responseJson.put("homepage", movie.getHomepage());
        responseJson.put("rating", movie.getRating());
        //TODO "google" an image by title and returns the url as json

        String response = responseJson.toJSONString();
         */
        out.println("It's a random movie by genre and returned as JSON Object!");
    }
}