package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

import static java.util.Arrays.asList;

public class QuestionDeck {
    Category pop = new Category("Pop", asList(0, 4, 8));
    Category science = new Category("Science", asList(1, 5, 9));
    Category sports = new Category("Sports", asList(2, 6, 10));
    Category rock = new Category("Rock", asList(3, 7, 11));

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

    String askQuestionFor(String currentCategory) {
        String question = null;
        if (pop.isNamed(currentCategory)) {
            question = pop.nextQuestion();
        }
        if (science.isNamed(currentCategory)) {
            question = science.nextQuestion();
        }
        if (sports.isNamed(currentCategory)) {
            question = sports.nextQuestion();
        }
        if (rock.isNamed(currentCategory)) {
            question = rock.nextQuestion();
        }
        if (question == null) {
            throw new QuestionForUnknownCategory();
        }
        System.out.println(question);
        return question;
    }

    String currentCategoryFor(int playerPosition) {
        if (pop.isPlacedOn(playerPosition)) return pop.name();
        if (science.isPlacedOn(playerPosition)) return science.name();
        if (sports.isPlacedOn(playerPosition)) return sports.name();
        if (rock.isPlacedOn(playerPosition)) return rock.name();
        return "Rock";
    }
}
