package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;
import java.util.List;

public class Category {
    private String name;
    private List<Integer> positions;
    private LinkedList<String> questions;

    public Category(String name, List<Integer> positions) {

        this.name = name;
        this.positions = positions;
        this.questions = new LinkedList<>();
    }

    public boolean isNamed(String categoryName) {
        return this.name.equals(categoryName);
    }

    public String nextQuestion() {
        if (questions.isEmpty()) {
            throw new NoMoreQuestion();
        }

        return questions.removeFirst();
    }

    public boolean isPlacedOn(int position) {
        return positions.contains(position);
    }

    public String name() {
        return name;
    }

    public void addQuestion(String question) {
        questions.add(question);
    }
}
