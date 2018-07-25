package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class QuestionDeckTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "4", "8"})
    void position_zero_is_a_pop_category(int playerPosition) {
        QuestionDeck questionDeck = new QuestionDeck();

        String actualCategory = questionDeck.currentCategoryFor(playerPosition);

        assertThat(actualCategory, is("Pop"));
    }
}