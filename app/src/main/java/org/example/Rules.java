package org.example;

/**
 * This class contains methods to check game status and move validity for Tic-Tac-Toe.
 * It can determine if the game is finished, if a player has won, or if a move is valid.
 */
public class Rules {

    /**
     * Determines whether the game has ended by a win or tie.
     * If a player has won, prints the final board and returns true.
     * If the board is full (tie), prints the final board and returns true.
     * Otherwise, returns false.
     *
     * @param board the Board object representing the current state
     * @return true if the game is finished (win or tie), false otherwise
     */
    public boolean isGameFinished(Board board) {
        String[][] b = board.board;
        // Check if X has won
        if (hasContestantWon(b, "  X  ")) {
            board.printBoard();
            return true;
        }
        // Check if O has won
        if (hasContestantWon(b, "  O  ")) {
            board.printBoard();
            return true;
        }
        // Check for empty spaces; if any, the game is not finished
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (!b[i][j].equals("  X  ") && !b[i][j].equals("  O  ")) return false;
        // If board is full and no winner, it's a tie
        board.printBoard();
        return true;
    }

    /**
     * Determines whether the given symbol has won on the board.
     *
     * @param b      the game board (String[][])
     * @param symbol the symbol to check for a win
     * @return true if the symbol has a winning row, column, or diagonal
     */
    public boolean hasContestantWon(String[][] b, String symbol) {
        return
                // Check rows
                (b[0][0].equals(symbol) && b[0][1].equals(symbol) && b[0][2].equals(symbol)) ||
                        (b[1][0].equals(symbol) && b[1][1].equals(symbol) && b[1][2].equals(symbol)) ||
                        (b[2][0].equals(symbol) && b[2][1].equals(symbol) && b[2][2].equals(symbol)) ||
                        // Check columns
                        (b[0][0].equals(symbol) && b[1][0].equals(symbol) && b[2][0].equals(symbol)) ||
                        (b[0][1].equals(symbol) && b[1][1].equals(symbol) && b[2][1].equals(symbol)) ||
                        (b[0][2].equals(symbol) && b[1][2].equals(symbol) && b[2][2].equals(symbol)) ||
                        // Check diagonals
                        (b[0][0].equals(symbol) && b[1][1].equals(symbol) && b[2][2].equals(symbol)) ||
                        (b[0][2].equals(symbol) && b[1][1].equals(symbol) && b[2][0].equals(symbol));
    }

    /**
     * Checks whether the given move is valid: the input must be a digit from 1-9,
     * and the corresponding cell must not already be taken.
     *
     * @param board    the Board object representing the current game state
     * @param position the cell number as a string
     * @return true if the move is valid, false otherwise
     */
    public static boolean isValidMove(Board board, String position) {
        int cell;
        try {
            cell = Integer.parseInt(position);
        } catch (NumberFormatException e) {
            return false;
        }
        if (cell < 1 || cell > 9) return false;
        int row = (cell - 1) / 3, col = (cell - 1) % 3;
        String valid = board.board[row][col];
        // Move is valid if the cell does not already contain X or O
        return !valid.equals("  X  ") && !valid.equals("  O  ");
    }
}
