package com.adaptionsoft.games.uglytrivia;

import java.util.List;

public class Category {
    private final String name;
    private List<Integer> places;

    public Category(String name, List<Integer> places) {
        this.name = name;
        this.places = places;
    }

    public boolean isPlacedOn(int position) {
        return places.contains(position);
    }

    public String name() {
        return name;
    }

    public boolean isNamed(String category) {
        return category.equals(name);
    }

    public String nextQuestion() {
        return "werifnerwoifuhi";
    }

    public void addQuestion(String question) {

    }
}
