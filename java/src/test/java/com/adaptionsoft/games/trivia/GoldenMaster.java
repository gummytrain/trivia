package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GoldenMaster {
    @Test
    void writeOutput() throws Exception {
        Path actualOutput = Paths.get("actual.log");
        Path expected = Paths.get("expected.log");

        PrintStream originalOut = System.out;

        try (PrintStream printStream = new PrintStream(actualOutput.toFile())) {
            System.setOut(printStream);

            for (int i = 0; i < 1000; i++) {
                new GameRunner().run(new Random(i));
            }

            assertThat(Files.readAllLines(actualOutput), is(Files.readAllLines(expected)));

        } finally {
            System.setOut(originalOut);
        }
    }
}
