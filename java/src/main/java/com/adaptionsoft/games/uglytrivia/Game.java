package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;

public class Game {
	private final PenaltyBox penaltyBox = new PenaltyBox();
	ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses  = new int[6];

	int currentPlayer = 0;
    private final QuestionDeck questionDeck;

	public Game(QuestionDeck aQuestionDeck){
		questionDeck = aQuestionDeck;
    }

    public boolean isPlayable() {
		return (howManyPlayers() >= 2);
	}

	public boolean add(String playerName) {
		
		
	    players.add(playerName);
	    places[howManyPlayers()] = 0;
	    purses[howManyPlayers()] = 0;
		penaltyBox.prepareEmptyPenaltyBox(this.howManyPlayers());

		System.out.println(playerName + " was added");
	    System.out.println("They are player number " + players.size());
		return true;
	}

	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) {
		System.out.println(players.get(currentPlayer) + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (penaltyBox.isInPenaltyBox(this.currentPlayer)) {
			if (roll % 2 != 0) {
				penaltyBox.currentPlayerIsGettingOut();
				System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");

			} else {
				System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
				penaltyBox.currentPlayerIsStaying();

				return;
			}
		}

		movePlayerAccordingTo(roll);

	}

	private void movePlayerAccordingTo(int roll) {
		places[currentPlayer] = places[currentPlayer] + roll;
		if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

		System.out.println(players.get(currentPlayer)
				+ "'s new location is "
				+ places[currentPlayer]);
		System.out.println("The category is " + currentCategory());
		askQuestion();
	}

	private void askQuestion() {
        System.out.println(questionDeck.askQuestionFor(currentCategory()));
    }


    private String currentCategory() {
        return questionDeck.currentCategoryForPosition(places[currentPlayer]);
    }

    public boolean wasCorrectlyAnswered() {
		if (penaltyBox.isInPenaltyBox(this.currentPlayer)){
			if (penaltyBox.isCurrentPlayerGettingOut()) {
				System.out.println("Answer was correct!!!!");
				purses[currentPlayer]++;
				System.out.println(players.get(currentPlayer) 
						+ " now has "
						+ purses[currentPlayer]
						+ " Gold Coins.");
				
				boolean winner = didPlayerWin();
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				
				return winner;
			} else {
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				return true;
			}
			
			
			
		} else {
		
			System.out.println("Answer was corrent!!!!");
			purses[currentPlayer]++;
			System.out.println(players.get(currentPlayer) 
					+ " now has "
					+ purses[currentPlayer]
					+ " Gold Coins.");
			
			boolean winner = didPlayerWin();
			currentPlayer++;
			if (currentPlayer == players.size()) currentPlayer = 0;
			
			return winner;
		}
	}

	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(players.get(currentPlayer)+ " was sent to the penalty box");
		penaltyBox.sendToPenaltyBox(this.currentPlayer);

		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
		return true;
	}


	private boolean didPlayerWin() {
		return !(purses[currentPlayer] == 6);
	}
}
