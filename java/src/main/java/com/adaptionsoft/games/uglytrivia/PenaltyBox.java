package com.adaptionsoft.games.uglytrivia;

public class PenaltyBox {
    boolean[] inPenaltyBox  = new boolean[6];
    boolean isGettingOutOfPenaltyBox;


    public void prepareEmptyPenaltyBox(int i) {
        this.inPenaltyBox[i] = false;
    }

    public boolean isInPenaltyBox(int currentPlayer) {
        return this.inPenaltyBox[currentPlayer];
    }

    public void sendToPenaltyBox(int currentPlayer) {
        this.inPenaltyBox[currentPlayer] = true;
    }

    public void currentPlayerIsGettingOut() {
        this.isGettingOutOfPenaltyBox = true;
    }

    public void currentPlayerIsStaying() {
        this.isGettingOutOfPenaltyBox = false;
    }

    public boolean isCurrentPlayerGettingOut() {
        return this.isGettingOutOfPenaltyBox;
    }

    public boolean isGettingOutWith(int roll) {
        return roll % 2 == 0;
    }
}
