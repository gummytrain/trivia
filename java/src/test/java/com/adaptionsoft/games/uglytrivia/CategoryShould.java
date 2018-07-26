package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class CategoryShould {

    @Test
    void isNamed() {
        Category category = new Category("banana", null);

        assertTrue(category.isNamed("banana"));
        assertThat(category.name(), is("banana"));
    }

    @Test
    void reportWhereItIsPlaced() {
        Category category = new Category("banana", asList(0, 1, 2));

        assertTrue(category.isPlacedOn(0));
        assertTrue(category.isPlacedOn(2));
        assertTrue(category.isPlacedOn(1));
    }

    @Test
    void reportWhereIsNotPlaced() {
        Category category = new Category("banana", asList(0, 1, 2));

        assertFalse(category.isPlacedOn(90));
    }


    @Test
    void hostQuestions() {
        Category history = new Category("history", emptyList());

        history.addQuestion("When was Gabriele born?");

        assertThat(history.nextQuestion(), is("When was Gabriele born?"));
    }

    @Test
    void notProvideAQuestionWhenThereArent() {
        Category history = new Category("banana", emptyList());

        assertThrows(NoMoreQuestion.class, history::nextQuestion);
    }
}