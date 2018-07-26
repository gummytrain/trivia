package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CategoryQuestionsShould {

    @Test
    void isNamed() {
        CategoryQuestions category = new CategoryQuestions("banana", null);

        assertTrue(category.isNamed("banana"));
        assertThat(category.name(), is("banana"));
    }

    @Test
    void bePlacedAccordingly() {
        CategoryQuestions category = new CategoryQuestions("banana", asList(0, 1, 2));

        assertTrue(category.isPlacedOn(0));
    }
}