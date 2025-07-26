package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the Player class.
 * It checks correct move placement and verifies board updates.
 */
class PlayerTest {

    /**
     * Tests that the placeMove method correctly places 'X' in the middle cell.
     */
    @Test
    void testPlaceMoveX() {
        String[][] arr = {
                {"  1  ", "  2  ", "  3  "},
                {"  4  ", "  5  ", "  6  "},
                {"  7  ", "  8  ", "  9  "}
        };
        Board board = new Board(arr);
        Player.placeMove(board, "5", 'X');
        assertEquals("  X  ", board.board[1][1]);
    }

    /**
     * Tests that the placeMove method correctly places 'O' in the top-left cell.
     */
    @Test
    void testPlaceMoveO() {
        String[][] arr = {
                {"  1  ", "  2  ", "  3  "},
                {"  4  ", "  5  ", "  6  "},
                {"  7  ", "  8  ", "  9  "}
        };
        Board board = new Board(arr);
        Player.placeMove(board, "1", 'O');
        assertEquals("  O  ", board.board[0][0]);
    }

    /**
     * Tests that the placeMove method correctly updates the board for cell 9.
     */
    @Test
    void testPlaceMoveUpdatesBoard() {
        String[][] arr = {
                {"  1  ", "  2  ", "  3  "},
                {"  4  ", "  5  ", "  6  "},
                {"  7  ", "  8  ", "  9  "}
        };
        Board board = new Board(arr);
        Player.placeMove(board, "9", 'X');
        assertEquals("  X  ", board.board[2][2]);
    }

    /**
     * Tests that multiple calls to placeMove work and update the correct cells.
     */
    @Test
    void testMultipleMoves() {
        String[][] arr = {
                {"  1  ", "  2  ", "  3  "},
                {"  4  ", "  5  ", "  6  "},
                {"  7  ", "  8  ", "  9  "}
        };
        Board board = new Board(arr);
        Player.placeMove(board, "2", 'O');
        Player.placeMove(board, "8", 'X');
        assertEquals("  O  ", board.board[0][1]);
        assertEquals("  X  ", board.board[2][1]);
    }
}
