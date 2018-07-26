package com.adaptionsoft.games.uglytrivia;

import java.util.List;

public class Category {
    private String name;
    private List<Integer> positions;

    public Category(String name, List<Integer> positions) {

        this.name = name;
        this.positions = positions;
    }

    public boolean isNamed(String categoryName) {
        return this.name.equals(categoryName);
    }

    public String nextQuestion() {
        return null;
    }

    public boolean isPlacedOn(int position) {
        return positions.contains(position);
    }

    public String name() {
        return name;
    }

    public void addQuestion(String question) {

    }
}
