package com.codecool.wheel.of.randomness.controller;

import com.codecool.wheel.of.randomness.dao.jdbc.GenreDaoJdbc;
import com.codecool.wheel.of.randomness.model.Genre;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/get-all-categories"})
public class GetCategoryNames  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenreDaoJdbc genreDaoJdbc = new GenreDaoJdbc();
        List<Genre> genreList = genreDaoJdbc.getAll();

        resp.setContentType("application/json"); resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        Gson gson = new Gson();
        String jsonString = gson.toJson(genreList);
        out.println(jsonString);
    }
}
