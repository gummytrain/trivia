package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class QuestionDeckTest {

    @ParameterizedTest
    @CsvSource({"0, Pop", "4, Pop", "8, Pop"})
    void position_zero_is_a_pop_category(int playerPosition, String expectedCategoy) {
        QuestionDeck questionDeck = new QuestionDeck();

        String actualCategory = questionDeck.currentCategoryFor(playerPosition);

        assertThat(actualCategory, is(expectedCategoy));
    }
}