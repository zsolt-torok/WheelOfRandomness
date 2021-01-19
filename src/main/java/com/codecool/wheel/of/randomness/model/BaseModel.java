package com.codecool.wheel.of.randomness.model;

public abstract class BaseModel {
    private int id;

    public BaseModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
