package org.example;

/**
 * This class provides static methods for handling player moves.
 * It is used by both human and computer players to place a symbol on the board.
 */
public class Player {

    /**
     * Places the player's symbol at the specified board position.
     * The position should be a string from 1 to 9 corresponding to the board cell.
     *
     * @param board    the Board object to update
     * @param position the cell number as a string
     * @param symbol   the symbol to place
     */
    public static void placeMove(Board board, String position, char symbol) {
        // Convert position (1-9) to 0-based row/col indices
        int cell = Integer.parseInt(position);
        int row  = (cell - 1) / 3;
        int col = (cell - 1) % 3;
        // Place the symbol on the board in the formatted string
        board.board[row][col] = "  " + symbol + "  ";
    }
}
