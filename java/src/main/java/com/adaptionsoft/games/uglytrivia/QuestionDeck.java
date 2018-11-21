package com.adaptionsoft.games.uglytrivia;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.lang.String.*;
import static java.util.Arrays.asList;

public class QuestionDeck {
    private final List<Category> categories;

    public QuestionDeck() {
        categories = asList(
                new Category("Pop", asList(0, 4, 8)),
                new Category("Science", asList(1, 5, 9)),
                new Category("Sports", asList(2, 6, 10)),
                new Category("Rock", asList(3, 7, 11)));
    }

    public void fillQuestions() {
        IntStream.range(0, 50).forEach(
                i -> categories.
                        forEach(category -> category.addQuestion(format("%s Question %d", category.name(), i)))
        );
    }

    String nextQuestionFor(String currentCategory) {
        return findCategory(category -> category.isNamed(currentCategory))
                .orElseThrow(QuestionForUnknownCategory::new)
                .nextQuestion();
    }

    String currentCategoryFor(int playerPosition) {
        return findCategory(category -> category.isPlacedOn(playerPosition))
                .orElseThrow(OutOfTheBoardException::new)
                .name();
    }

    private Optional<Category> findCategory(Predicate<Category> predicate) {
        return categories.stream()
                .filter(predicate)
                .findFirst();
    }
}
