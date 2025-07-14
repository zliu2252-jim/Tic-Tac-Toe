package org.example;

/**
 * This class contains static methods to check the game status,
 * validating moves, and determining if a player ('X' or 'O') has won in Tic-Tac-Toe.
 */
public class Rules {

    /**
     * Checks if the Tic-Tac-Toe board state ends the game.
     * Prints the final board and a message if there is a winner or a tie.
     *
     * @param board The Board object representing the Tic-Tac-Toe board
     * @return true if the game has ended, false otherwise
     */
    public static boolean isGameFinished(Board board) {
        char[][] b = board.getBoard();
        // Check for win by X
        if (hasContestantWon(board, 'X')) {
            board.printBoard();
            System.out.println("Player X wins!");
            return true;
        }
        // Check for win by O
        if (hasContestantWon(board, 'O')) {
            board.printBoard();
            System.out.println("Player O wins!");
            return true;
        }
        // Check for tie
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = b[i][j];
                if (c != 'X' && c != 'O') {
                    return false;
                }
            }
        }
        board.printBoard();
        System.out.println("The game ended in a tie!");
        return true;
    }

    /**
     * Checks if the given player has won the game.
     * A win is three matching symbols in a row, column, or diagonal.
     *
     * @param board The Board object representing the Tic-Tac-Toe board
     * @param symbol The player's symbol ('X' or 'O')
     * @return true if the player has won, false otherwise
     */
    public static boolean hasContestantWon(Board board, char symbol) {
        char[][] b = board.getBoard();
        return
                (b[0][0]==symbol && b[0][1]==symbol && b[0][2]==symbol) ||
                        (b[1][0]==symbol && b[1][1]==symbol && b[1][2]==symbol) ||
                        (b[2][0]==symbol && b[2][1]==symbol && b[2][2]==symbol) ||
                        (b[0][0]==symbol && b[1][0]==symbol && b[2][0]==symbol) ||
                        (b[0][1]==symbol && b[1][1]==symbol && b[2][1]==symbol) ||
                        (b[0][2]==symbol && b[1][2]==symbol && b[2][2]==symbol) ||
                        (b[0][0]==symbol && b[1][1]==symbol && b[2][2]==symbol) ||
                        (b[0][2]==symbol && b[1][1]==symbol && b[2][0]==symbol);
    }

    /**
     * Validates if a player's move is legal.
     *
     * @param board The Board object representing the Tic-Tac-Toe board
     * @param position The player's input string (1-9)
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
        char val = board.getCell(row, col);
        return val != 'X' && val != 'O';
    }
}