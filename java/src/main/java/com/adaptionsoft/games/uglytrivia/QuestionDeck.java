package com.adaptionsoft.games.uglytrivia;

public class QuestionDeck {
    public String createRockQuestion(int index){
        return "Rock Question " + index;
    }

    public void fillQuestions(Game game) {
        for (int i = 0; i < 50; i++) {
            game.popQuestions.addLast("Pop Question " + i);
            game.scienceQuestions.addLast(("Science Question " + i));
            game.sportsQuestions.addLast(("Sports Question " + i));
            game.rockQuestions.addLast(createRockQuestion(i));
        }
    }
}
