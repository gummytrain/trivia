package com.adaptionsoft.games.uglytrivia;

import java.util.List;

import static java.lang.String.*;
import static java.util.Arrays.asList;

public class QuestionDeck {
    private final List<Category> categories;

    public QuestionDeck() {
        categories = asList(
                new Category("Pop", asList(0, 4, 8)),
                new Category("Science", asList(1, 5, 9)),
                new Category("Sports", asList(2, 6, 10)),
                new Category("Rock", asList(3, 7, 11)));
    }

    public void fillQuestions() {
        for (int i = 0; i < 50; i++) {
            for (Category category : categories) {
                category.addQuestion(format("%s Question %d", category.name(), i));
            }
        }
    }

    String nextQuestionFor(String currentCategory) {
        return categories.stream()
                .filter(category -> category.isNamed(currentCategory))
                .findFirst()
                .orElseThrow(QuestionForUnknownCategory::new)
                .nextQuestion();
    }

    String currentCategoryFor(int playerPosition) {
        for (Category category : categories) {
            if (category.isPlacedOn(playerPosition))
                return category.name();
        }
        throw new OutOfTheBoardException();
    }
}
