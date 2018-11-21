package com.adaptionsoft.games.uglytrivia;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class QuestionDeck {
    LinkedList<String> popQuestions = new LinkedList();
    List<Integer> popPlaces = asList(0, 4, 8);
    LinkedList<String> scienceQuestions = new LinkedList();
    List<Integer> sciencePlaces = asList(1, 5, 9);
    LinkedList<String> sportsQuestions = new LinkedList();
    List<Integer> sportsPlaces = asList(2, 6, 10);
    LinkedList<String> rockQuestions = new LinkedList();
    List<Integer> rockPlaces = asList(3, 7, 11);
    Category pop = new Category("wfiewin", Collections.emptyList()  );

    public String createQuestion(int index, final String category) {
        return category + " Question " + index;
    }

    public void fillQuestions() {
        for (int i = 0; i < 50; i++) {
            this.pop.addQuestion(createQuestion(i, "Pop"));
            this.popQuestions.addLast(createQuestion(i, "Pop"));
            this.scienceQuestions.addLast(createQuestion(i, "Science"));
            this.sportsQuestions.addLast(createQuestion(i, "Sports"));
            this.rockQuestions.addLast(createQuestion(i, "Rock"));
        }
    }

    String askQuestionFor(String currentCategory) {
        if(pop.isNamed(currentCategory)) {
            String question = pop.nextQuestion();
            System.out.println(question);
            return question;
        }
        if (currentCategory.equals("Pop")) {
            String question = this.popQuestions.removeFirst();
            System.out.println(question);
            return question;
        }
        if (currentCategory.equals("Science")) {
            String question = this.scienceQuestions.removeFirst();
            System.out.println(question);
            return question;
        }
        if (currentCategory.equals("Sports")) {
            String question = this.sportsQuestions.removeFirst();
            System.out.println(question);
            return question;
        }
        if (currentCategory.equals("Rock")) {
            String question = this.rockQuestions.removeFirst();
            System.out.println(question);
            return question;
        }
        return null;
    }

    String currentCategoryFor(int playerPosition) {
        if (pop.isPlacedOn(playerPosition)) return pop.name();
        if (popPlaces.contains(playerPosition)) return "Pop";
        if (sciencePlaces.contains(playerPosition)) return "Science";
        if (sportsPlaces.contains(playerPosition)) return "Sports";
        if (rockPlaces.contains(playerPosition)) return "Rock";
        return "Rock";
    }
}
