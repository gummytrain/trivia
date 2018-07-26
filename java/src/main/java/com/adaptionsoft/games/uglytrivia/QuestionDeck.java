package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class QuestionDeck {
    LinkedList<String> popQuestions = new LinkedList();
    LinkedList<String> scienceQuestions = new LinkedList();
    LinkedList<String> sportsQuestions = new LinkedList();
    LinkedList<String> rockQuestions = new LinkedList();

    public String createQuestion(int index, final String category){
        return category + " Question " + index;
    }

    public void fillQuestions() {
        for (int i = 0; i < 50; i++) {
            this.popQuestions.addLast(createQuestion(i, "Pop"));
            this.scienceQuestions.addLast(createQuestion(i, "Science"));
            this.sportsQuestions.addLast(createQuestion(i, "Sports"));
            this.rockQuestions.addLast(createQuestion(i, "Rock"));
        }
    }

    String askQuestionFor(String currentCategory) {
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
        if (playerPosition == 0) return "Pop";
        if (playerPosition == 4) return "Pop";
        if (playerPosition == 8) return "Pop";
        if (playerPosition == 1) return "Science";
        if (playerPosition == 5) return "Science";
        if (playerPosition == 9) return "Science";
        if (playerPosition == 2) return "Sports";
        if (playerPosition == 6) return "Sports";
        if (playerPosition == 10) return "Sports";
        return "Rock";
    }
}
