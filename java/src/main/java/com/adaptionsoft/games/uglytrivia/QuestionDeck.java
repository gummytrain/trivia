package com.adaptionsoft.games.uglytrivia;

import java.util.List;

import static java.lang.String.*;
import static java.util.Arrays.asList;

public class QuestionDeck {
    Category pop = new Category("Pop", asList(0, 4, 8));
    Category science = new Category("Science", asList(1, 5, 9));
    Category sports = new Category("Sports", asList(2, 6, 10));
    Category rock = new Category("Rock", asList(3, 7, 11));
    private final List<Category> categories;

    public QuestionDeck() {
        categories = asList(pop, science, sports, rock);
    }

    public void fillQuestions() {
        for (int i = 0; i < 50; i++) {
            for (Category category : categories) {
                category.addQuestion(format("%s Question %d", category.name(), i));
            }
        }
    }

    String nextQuestionFor(String currentCategory) {
        String question = null;

        for (Category category : categories) {
            if (category.isNamed(currentCategory))
                question = category.nextQuestion();
        }
        if (question == null) {
            throw new QuestionForUnknownCategory();
        }
        return question;
    }

    String currentCategoryFor(int playerPosition) {
        for (Category category : categories) {
            if (category.isPlacedOn(playerPosition))
                return category.name();
        }
        throw new OutOfTheBoardException();
    }
}
