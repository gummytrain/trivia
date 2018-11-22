package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PenaltyBoxTest {

    public static final int PLAYER_0 = 0;
    private PenaltyBox penaltyBox;

    @BeforeEach
    void setUp() {
        penaltyBox = new PenaltyBox();
    }

    @Test
    void player_is_not_in_if_not_sent() {
        penaltyBox.prepareEmptyPenaltyBox(PLAYER_0);

        assertFalse(penaltyBox.isInPenaltyBox(PLAYER_0));
    }

    @Test
    void player_is_in_if_it_was_sent() {
        penaltyBox.prepareEmptyPenaltyBox(PLAYER_0);
        penaltyBox.sendToPenaltyBox(PLAYER_0);

        assertTrue(penaltyBox.isInPenaltyBox(PLAYER_0));
    }

    @Test
    void is_not_getting_out_with_odd() {
        assertTrue(penaltyBox.isNotGettingOutWith(2));
        assertTrue(penaltyBox.isNotGettingOutWith(4));
        assertTrue(penaltyBox.isNotGettingOutWith(6));
        assertTrue(penaltyBox.isNotGettingOutWith(8));
    }

    @Test
    void set_is_getting_out() {
        penaltyBox.currentPlayerIsGettingOut();

        assertTrue(penaltyBox.isCurrentPlayerGettingOut());
    }

    @Test
    void set_is_staying_in() {
        penaltyBox.currentPlayerIsStaying();

        assertFalse(penaltyBox.isCurrentPlayerGettingOut());
    }

    @Test
    void is_getting_out_with_even() {
        assertFalse(penaltyBox.isNotGettingOutWith(3));
        assertFalse(penaltyBox.isNotGettingOutWith(5));
        assertFalse(penaltyBox.isNotGettingOutWith(1));
        assertFalse(penaltyBox.isNotGettingOutWith(7));
    }
}