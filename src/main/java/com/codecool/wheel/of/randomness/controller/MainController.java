package com.codecool.wheel.of.randomness.controller;


import com.codecool.wheel.of.randomness.config.TemplateEngineUtil;
import com.codecool.wheel.of.randomness.dao.MovieDao;
import com.codecool.wheel.of.randomness.model.Movie;
import org.json.simple.JSONObject;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/"})
public class MainController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        //TODO implement CategoryDao
        //CategoryDao categoryDao = new CategoryDao();

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());

        WebContext context = new WebContext(req, resp, req.getServletContext());
        //context.setVariable("categories", categoryDao.getAll());


        engine.process("main.html", context, resp.getWriter());
    }
}