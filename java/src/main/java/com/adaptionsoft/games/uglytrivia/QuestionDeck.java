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
        if(pop.isNamed(currentCategory)) {
            String question = pop.nextQuestion();
            System.out.println(question);
            return question;
        }
        if(science.isNamed(currentCategory)) {
            String question = science.nextQuestion();
            System.out.println(question);
            return question;
        }if(sports.isNamed(currentCategory)) {
            String question = sports.nextQuestion();
            System.out.println(question);
            return question;
        }if(rock.isNamed(currentCategory)) {
            String question = rock.nextQuestion();
            System.out.println(question);
            return question;
        }
        return null;
    }

    String currentCategoryFor(int playerPosition) {
        if (pop.isPlacedOn(playerPosition)) return pop.name();
        if (science.isPlacedOn(playerPosition)) return science.name();
        if (sports.isPlacedOn(playerPosition)) return sports.name();
        if (rock.isPlacedOn(playerPosition)) return rock.name();
        return "Rock";
    }
}
