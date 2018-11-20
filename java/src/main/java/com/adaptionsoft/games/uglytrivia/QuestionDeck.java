package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class QuestionDeck {
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    public String createRockQuestion(int index){
        return "Rock Question " + index;
    }

    public void fillQuestions() {
        for (int i = 0; i < 50; i++) {
            this.popQuestions.addLast("Pop Question " + i);
            this.scienceQuestions.addLast(("Science Question " + i));
            this.sportsQuestions.addLast(("Sports Question " + i));
            this.rockQuestions.addLast(createRockQuestion(i));
        }
    }

    Object askQuestionFor(String currentCategory) {
        if (currentCategory == "Pop") {
            Object question = this.popQuestions.removeFirst();
            System.out.println(question);
            return question;
        }
        if (currentCategory == "Science") {
            Object question = this.scienceQuestions.removeFirst();
            System.out.println(question);
            return question;
        }
        if (currentCategory == "Sports") {
            Object question = this.sportsQuestions.removeFirst();
            System.out.println(question);
            return question;
        }
        if (currentCategory == "Rock") {
            Object question = this.rockQuestions.removeFirst();
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
