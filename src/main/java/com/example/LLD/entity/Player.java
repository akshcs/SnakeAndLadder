package com.example.LLD.entity;

public class Player {
    private final String name;

    public String getColor() {
        return color;
    }

    private final String color;

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    private int currentPosition;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.currentPosition = 0;
    }
}
