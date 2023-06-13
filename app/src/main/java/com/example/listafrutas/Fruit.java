package com.example.listafrutas;

import java.io.Serializable;
import java.util.List;

public class Fruit implements Serializable {
    private String name;
    private double cost;
    private int imageResId;

    public Fruit(String name, double cost, int imageResId) {
        this.name = name;
        this.cost = cost;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getImageResId() {
        return imageResId;
    }
}
