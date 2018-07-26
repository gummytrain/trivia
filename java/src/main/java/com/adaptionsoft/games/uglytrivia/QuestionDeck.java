package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;
import java.util.List;

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

    public String createQuestion(int index, final String category) {
        return category + " Question " + index;
    }

    public void fillQuestions() {
        for (int i = 0; i < 50; i++) {
            this.pop.addQuestion(createQuestion(i, pop.name()));
            this.science.addQuestion(createQuestion(i, science.name()));
            this.sports.addQuestion(createQuestion(i, sports.name()));
            this.rock.addQuestion(createQuestion(i, rock.name()));
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

        if (pop.isPlacedOn(playerPosition)) return pop.name();
        if (science.isPlacedOn(playerPosition)) return science.name();
        if (sports.isPlacedOn(playerPosition)) return sports.name();
        if (rock.isPlacedOn(playerPosition)) return rock.name();
        throw new OutOfTheBoardException();
    }
}
