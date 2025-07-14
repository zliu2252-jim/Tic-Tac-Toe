package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Rules class, which checks game logic such as
 * win detection.
 */
class RulesTest {

    /**
     * Tests that hasContestantWon detects a win in the first row.
     */
    @Test
    void testRowWin() {
        Board board = new Board();
        board.setCell(0,0,'O');
        board.setCell(0,1,'O');
        board.setCell(0,2,'O');
        assertTrue(Rules.hasContestantWon(board, 'O'));
    }

    /**
     * Tests that hasContestantWon detects a win in the last column.
     */
    @Test
    void testColWin() {
        Board board = new Board();
        board.setCell(0,2,'X');
        board.setCell(1,2,'X');
        board.setCell(2,2,'X');
        assertTrue(Rules.hasContestantWon(board, 'X'));
    }

    /**
     * Tests that hasContestantWon detects a win on the main diagonal.
     */
    @Test
    void testDiagonalWin() {
        Board board = new Board();
        board.setCell(0,0,'X');
        board.setCell(1,1,'X');
        board.setCell(2,2,'X');
        assertTrue(Rules.hasContestantWon(board, 'X'));
    }

    /**
     * Tests isValidMove for valid.
     */
    @Test
    void testIsValidMoveTrueFalse() {
        Board board = new Board();
        assertTrue(Rules.isValidMove(board, "1"));
        board.setCell(0,0,'X');
        assertFalse(Rules.isValidMove(board, "1"));
        assertFalse(Rules.isValidMove(board, "10"));
        assertFalse(Rules.isValidMove(board, "abc"));
    }
}