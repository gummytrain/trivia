package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    void placed_categories(int playerPosition, String expectedCategory) {
        QuestionDeck questionDeck = new QuestionDeck();

        String actualCategory = questionDeck.currentCategoryFor(playerPosition);

        assertThat(actualCategory, is(expectedCategory));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12", "99999", "-1", "" + Integer.MAX_VALUE})
    void out_of_the_board(int playerPosition) {
        QuestionDeck questionDeck = new QuestionDeck();

        String actualCategory = questionDeck.currentCategoryFor(playerPosition);

        assertThat(actualCategory, is("Rock"));
    }

    @Test
    void askingFirstPopQuestion() {
        QuestionDeck questionDeck = new QuestionDeck();

        questionDeck.fillQuestions();

        assertThat(questionDeck.askQuestionFor("Pop"), is("Pop Question 0"));
    }

    @Test
    void askMultiplePopQuestion() {
        QuestionDeck questionDeck = new QuestionDeck();

        questionDeck.fillQuestions();

        assertThat(questionDeck.askQuestionFor("Pop"), is("Pop Question 0"));
        assertThat(questionDeck.askQuestionFor("Pop"), is("Pop Question 1"));
        assertThat(questionDeck.askQuestionFor("Pop"), is("Pop Question 2"));
        assertThat(questionDeck.askQuestionFor("Pop"), is("Pop Question 3"));
        assertThat(questionDeck.askQuestionFor("Pop"), is("Pop Question 4"));
    }
}