package com.adaptionsoft.games.uglytrivia;

public class CategoryQuestions {
    private String name;

    public CategoryQuestions(String name) {

        this.name = name;
    }

    public boolean isNamed(String categoryName) {
        return this.name.equals(categoryName);
    }

    public String nextQuestion() {
        return null;
    }

    public boolean isPlacedOn(int position) {
        return false;
    }

    public String name() {
        return name;
    }

    public void addQuestion(String question) {

    }
}
