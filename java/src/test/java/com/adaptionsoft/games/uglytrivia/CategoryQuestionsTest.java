package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CategoryQuestionsTest {

    @Test
    void isNamed() {
        CategoryQuestions questions = new CategoryQuestions("banana");

        assertTrue(questions.isNamed("banana"));
        assertThat(questions.name(), is("banana"));
    }
}