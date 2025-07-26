package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the Human class.
 * It verifies user move placement, input validation, and symbol correctness.
 */
class HumanTest {

    /**
     * Tests that the Human move method places the correct symbol at the chosen cell.
     */
    @Test
    void testMovePlacesCorrectSymbol() {
        String[][] arr = {
                {"  1  ", "  2  ", "  3  "},
                {"  4  ", "  5  ", "  6  "},
                {"  7  ", "  8  ", "  9  "}
        };
        Board board = new Board(arr);
        String simulatedInput = "1\n";
        Scanner scnr = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        Human human = new Human('X', board, scnr);
        human.move();
        assertEquals("  X  ", board.board[0][0]);
    }

    /**
     * Tests that the Human move method rejects an invalid input and prompts again.
     */
    @Test
    void testMoveRejectsInvalid() {
        String[][] arr = {
                {"  1  ", "  2  ", "  3  "},
                {"  4  ", "  5  ", "  6  "},
                {"  7  ", "  8  ", "  9  "}
        };
        Board board = new Board(arr);
        String simulatedInput = "11\n2\n";
        Scanner scnr = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        Human human = new Human('O', board, scnr);
        human.move();
        assertEquals("  O  ", board.board[0][1]);
    }

    /**
     * Tests that the Human can make a move to a different cell.
     */
    @Test
    void testMultipleMoves() {
        String[][] arr = {
                {"  1  ", "  2  ", "  3  "},
                {"  4  ", "  5  ", "  6  "},
                {"  7  ", "  8  ", "  9  "}
        };
        Board board = new Board(arr);
        String simulatedInput = "5\n";
        Scanner scnr = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        Human human = new Human('X', board, scnr);
        human.move();
        assertEquals("  X  ", board.board[1][1]);
    }

    /**
     * Tests that the Human move method uses the correct symbol for the player.
     */
    @Test
    void testSymbolSetCorrectly() {
        String[][] arr = {
                {"  1  ", "  2  ", "  3  "},
                {"  4  ", "  5  ", "  6  "},
                {"  7  ", "  8  ", "  9  "}
        };
        Board board = new Board(arr);
        String simulatedInput = "3\n";
        Scanner scnr = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        Human human = new Human('O', board, scnr);
        human.move();
        assertEquals("  O  ", board.board[0][2]);
    }
}
