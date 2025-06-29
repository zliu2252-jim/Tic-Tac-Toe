package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * End-to-end JUnit tests for the TicTacToeApp driver program.
 * These tests simulate two human players X and O via System.in,
 * verify the welcome banner, gameplay outcomes,
 * replay prompt handling, and goodbye message.
 * <p>
 * Ensures the code provides a driver for human-vs-human play and
 * includes comprehensive JUnit coverage for the main class.
 *
 * @author Zhengjia Liu
 */
class AppTest {

    /** Backup of the original System.in to restore after tests */
    private final InputStream originalIn  = System.in;
    /** Backup of the original System.out to restore after tests */
    private final PrintStream originalOut = System.out;

    /** Stream to simulate user input */
    private ByteArrayInputStream testIn;
    /** Stream to capture program output */
    private ByteArrayOutputStream testOut;

    /**
     * Before each test, redirect System.out to capture program output.
     */
    @BeforeEach
    void setUpStreams() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    /**
     * After each test, restore the original System.in and System.out.
     */
    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    /**
     * Builds the simulated stdin content:
     * Each integer in moves[] becomes one line (the cell choice).
     * Each extraLines entry becomes one line (replay answers).
     *
     * @param moves sequence of cell numbers 1–9 representing alternating X/O moves
     * @param extraLines lines to answer the "play again" prompt
     * @return concatenated input string with line separators
     */
    private String buildInput(int[] moves, String... extraLines) {
        StringBuilder sb = new StringBuilder();
        for (int m : moves) {
            sb.append(m).append(System.lineSeparator());
        }
        for (String line : extraLines) {
            sb.append(line).append(System.lineSeparator());
        }
        return sb.toString();
    }

    /**
     * Runs the TicTacToeApp.main driver with the given stdin content,
     * captures all stdout output, and returns it for assertions.
     *
     * @param input the full simulated stdin content
     * @return the captured stdout output
     */
    private String runMain(String input) {
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        // Invoke the driver program for human-vs-human game
        TicTacToeApp.main(new String[]{});
        return testOut.toString();
    }

    /**
     * Scenario: X wins on the first column (moves 1,4,7), O interleaves moves 2 and 5.
     * Then the user declines to play again.
     * Verifies:
     * Welcome banner is shown
     * "Player X wins!" is printed
     * Replay prompt appears
     * Goodbye message on "no"
     */
    @Test
    void whenXWins_thenWinMessageAndGoodbye() {
        int[] moves = {1, 2, 4, 5, 7};
        String input = buildInput(moves, "no");

        String output = runMain(input);

        assertTrue(output.contains("Welcome to Tic-Tac-Toe!"),
                "Should display welcome banner");
        assertTrue(output.contains("Player X wins!"),
                "Should announce that X wins");
        assertTrue(output.contains("Would you like to play again (yes/no)?"),
                "Should prompt to play again");
        assertTrue(output.contains("Goodbye!"),
                "Should print goodbye at end");
    }

    /**
     * Scenario: After X wins, user enters an invalid reply to the replay prompt,
     * then finally "no". Verifies that invalid entry is rejected but program continues.
     */
    @Test
    void invalidReplayEntry_repromptsThenStops() {
        int[] moves = {1, 2, 4, 5, 7};
        String input = buildInput(moves, "foobar", "no");

        String output = runMain(input);

        assertTrue(output.contains("Player X wins!"),
                "Should announce X wins");
        assertTrue(output.contains("That is not a valid entry!"),
                "Should warn on invalid replay entry");
        assertTrue(output.contains("Goodbye!"),
                "Should eventually say goodbye");
    }

    /**
     * Scenario: Full-board draw, then user declines replay.
     * Sequence: X and O alternate to fill all 9 cells without a winner.
     * Verifies draw message and goodbye.
     */
    @Test
    void fullBoardDraw_thenTieAndGoodbye() {
        int[] drawMoves = {1, 2, 3, 5, 4, 6, 8, 7, 9};
        String input = buildInput(drawMoves, "no");

        String output = runMain(input);

        assertTrue(output.contains("The game ended in a tie!"),
                "Should announce a draw");
        assertTrue(output.contains("Goodbye!"),
                "Should print goodbye at end");
    }
}
