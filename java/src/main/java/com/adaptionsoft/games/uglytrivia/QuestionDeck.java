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

    void askQuestionFor(String currentCategory) {
        if (currentCategory == "Pop")
            System.out.println(this.popQuestions.removeFirst());
        if (currentCategory == "Science")
            System.out.println(this.scienceQuestions.removeFirst());
        if (currentCategory == "Sports")
            System.out.println(this.sportsQuestions.removeFirst());
        if (currentCategory == "Rock")
            System.out.println(this.rockQuestions.removeFirst());
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
