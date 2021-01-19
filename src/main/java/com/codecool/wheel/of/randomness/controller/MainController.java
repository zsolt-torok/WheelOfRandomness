package com.codecool.wheel.of.randomness.controller;


import com.codecool.wheel.of.randomness.config.DataManager;
import com.codecool.wheel.of.randomness.config.TemplateEngineUtil;
import com.codecool.wheel.of.randomness.dao.GenreDao;
import com.codecool.wheel.of.randomness.dao.jdbc.GenreDaoJdbc;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/"})
public class MainController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        GenreDao genreDao = new GenreDaoJdbc(DataManager.connectDataBase());

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());

        WebContext context = new WebContext(req, resp, req.getServletContext());

        context.setVariable("categories", genreDao.getAll());

        engine.process("main.html", context, resp.getWriter());
    }
}