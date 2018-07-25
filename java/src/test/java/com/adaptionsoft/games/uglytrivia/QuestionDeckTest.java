package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class QuestionDeckTest {

    @Test
    void position_zero_is_a_pop_category() {
        QuestionDeck questionDeck = new QuestionDeck();

        String actualCategory = questionDeck.currentCategoryFor(0);

        assertThat(actualCategory, is("Pop"));
    }
}