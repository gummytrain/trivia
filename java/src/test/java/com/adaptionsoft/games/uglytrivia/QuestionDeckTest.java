package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class QuestionDeckTest {

    @ParameterizedTest
    @CsvSource({
            "0, Pop", "4, Pop", "8, Pop",
            "1, Science", "5, Science", "9, Science",
            "2, Sports", "6, Sports", "10, Sports",
            "3, Rock", "7, Rock", "11, Rock",
    })
    void question_for_categories_placed_explicitly(int position, String expectedCategory) {
        String actualCategory = new QuestionDeck().currentCategoryForPosition(position);

        assertThat(actualCategory, is(expectedCategory));
    }

    @Test
    void question_out_of_the_board() {
        String actualCategory = new QuestionDeck().currentCategoryForPosition(32832932);

        assertThat(actualCategory, is("Rock"));
    }
}