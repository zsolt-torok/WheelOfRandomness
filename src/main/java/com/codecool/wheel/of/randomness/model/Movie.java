package com.codecool.wheel.of.randomness.model;


import java.util.List;

// TODO separate class for most of fields: genre, season, episode, actor, character
public class Movie extends BaseModel {
    private String title;
    private String date;
    private String overView;
    private int runTime;
    private String trailerUrl;
    private String homePageUrl;
    private double rating;

    public Movie(int id) {
        super(id);
    }

    public Movie(int id,
                 String title,
                 String date,
                 String overView,
                 int runTime,
                 String trailerUrl,
                 String homePageUrl,
                 double rating) {
        super(id);
        this.title = title;
        this.date = date;
        this.overView = overView;
        this.runTime = runTime;
        this.trailerUrl = trailerUrl;
        this.homePageUrl = homePageUrl;
        this.rating = rating;
    }


    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getOverView() {
        return overView;
    }

    public int getRunTime() {
        return runTime;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }

    public double getRating() {
        return rating;
    }
}
