package com.codecool.wheel.of.randomness.model;

public class Genre extends BaseModel {
    private String name;

    public Genre(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
