package com.adaptionsoft.games.uglytrivia;

public class PenaltyBox {
    boolean[] inPenaltyBox  = new boolean[6];

    public void prepareEmptyPenaltyBox(int i) {
        this.inPenaltyBox[i] = false;
    }

    public boolean isInPenaltyBox(int currentPlayer) {
        return this.inPenaltyBox[currentPlayer];
    }

    public void sendToPenaltyBox(int currentPlayer) {
        this.inPenaltyBox[currentPlayer] = true;
    }
}
