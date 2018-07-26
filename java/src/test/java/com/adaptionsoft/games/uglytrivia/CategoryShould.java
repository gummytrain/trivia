package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void notProvideAQuestionWhenThereArent() {
        Category history = new Category("history", Collections.emptyList());

        assertThrows(NoMoreQuestion.class, history::nextQuestion);
    }
}