package org.example;

import java.util.Scanner;

/**
 * This class implements Tic-Tac-Toe game for two human players.
 * Players take turns marking cells numbered 1–9 on a 3*3 grid. The game
 * detects wins, draws, and offers a “play again” prompt with input validation.
 *
 * @author Zhengjia Liu
 */
public class App {

    /**
     * Entry point of the application. Displays a welcome message, then
     * repeatedly runs one full game, and finally prompts
     * the user whether to play again.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");

        // Outer loop: repeat entire game while user chooses “yes”
        do {
            // initialize board to labels '1-9'
            char[][] board = {
                    {'1','2','3'},
                    {'4','5','6'},
                    {'7','8','9'}
            };

            // Display the initial board
            printBoard(board);

            // Inner loop: alternate turns until win or draw
            while (true) {
                // X's turn
                playerMove(board, scnr, 'X');
                if (isGameFinished(board)) break;
                printBoard(board);

                // O's turn
                playerMove(board, scnr, 'O');
                if (isGameFinished(board)) break;
                printBoard(board);
            }
        } while (askPlayAgain(scnr));

        System.out.println("Goodbye!");
        scnr.close();
    }

    /**
     * Prompts the user to decide whether to play again. Accepts
     * yes or no. Repeats prompt on any other input.
     *
     * @param scnr Scanner for reading user input
     * @return true if user wants to play again, false otherwise
     */
    private static boolean askPlayAgain(Scanner scnr) {
        while (true) {
            System.out.print("\nWould you like to play again (yes/no)? ");
            String entry = scnr.nextLine().trim();
            if (entry.equalsIgnoreCase("yes") || entry.equalsIgnoreCase("y")) {
                return true;
            }
            if (entry.equalsIgnoreCase("no") || entry.equalsIgnoreCase("n")) {
                return false;
            }
            // Invalid response
            System.out.println("That is not a valid entry!");
        }
    }

    /**
     * Checks the current board for a win or draw. If a player has three
     * in a row, prints the final board and a win message. If board is full
     * without a winner, prints the final board and a draw message.
     *
     * @param board 3*3 character grid of current marks
     * @return true if the game has ended (win or draw), false otherwise
     */
    private static boolean isGameFinished(char[][] board) {
        // check for X win
        if (hasContestantWon(board, 'X')) {
            printBoard(board);
            System.out.println("Player X wins!");
            return true;
        }
        // Check for O win
        if (hasContestantWon(board, 'O')) {
            printBoard(board);
            System.out.println("Player O wins!");
            return true;
        }
        // Check for any remaining moves (digits 1–9 indicate empty)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i][j];
                if (c != 'X' && c != 'O') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie!");
        return true;
    }

    /**
     * Determines if the specified symbol has three in a row on the board.
     *
     * @param board 3*3 grid of current marks
     * @param symbol 'X' or 'O' to check
     * @return true if that symbol occupies any winning line
     */
    private static boolean hasContestantWon(char[][] board, char symbol) {
        return
                // Rows
                (board[0][0]==symbol && board[0][1]==symbol && board[0][2]==symbol) ||
                        (board[1][0]==symbol && board[1][1]==symbol && board[1][2]==symbol) ||
                        (board[2][0]==symbol && board[2][1]==symbol && board[2][2]==symbol) ||
                        // Columns
                        (board[0][0]==symbol && board[1][0]==symbol && board[2][0]==symbol) ||
                        (board[0][1]==symbol && board[1][1]==symbol && board[2][1]==symbol) ||
                        (board[0][2]==symbol && board[1][2]==symbol && board[2][2]==symbol) ||
                        // Diagonals
                        (board[0][0]==symbol && board[1][1]==symbol && board[2][2]==symbol) ||
                        (board[0][2]==symbol && board[1][1]==symbol && board[2][0]==symbol);
    }

    /**
     * Validates whether the user’s input corresponds to an empty cell.
     * Rejects non-integer input, out-of-range numbers, or value already-taken cells.
     *
     * @param board    current 3*3 grid
     * @param position user input string representing the cell number
     * @return true if the move is valid, false otherwise
     */
    private static boolean isValidMove(char[][] board, String position) {
        int cell;
        try {
            cell = Integer.parseInt(position);
        } catch (NumberFormatException e) {
            return false;
        }
        // Must be in 1–9
        if (cell < 1 || cell > 9) return false;

        // Map 1–9 to row/column
        int row = (cell - 1) / 3;
        int col = (cell - 1) % 3;
        // Valid if not already X or O
        return board[row][col] != 'X' && board[row][col] != 'O';
    }

    /**
     * Prompts the specified player for a move until a valid value is entered.
     * Then places the symbol on the board.
     *
     * @param board  current 3*3 grid
     * @param scnr   Scanner for input
     * @param symbol 'X' or 'O' indicating current player
     */
    private static void playerMove(char[][] board, Scanner scnr, char symbol) {
        String inp;
        while (true) {
            System.out.println("Player " + symbol + ", what is your move? (1-9):");
            inp = scnr.nextLine().trim();
            if (isValidMove(board, inp)) break;
            System.out.println("This is not a valid move: " + inp + ". Try again.");
        }
        placeMove(board, inp, symbol);
    }

    /**
     * Places the given symbol into the board cell specified by position.
     *
     * @param board current 3×3 grid
     * @param position string "1"-"9" indicating cell
     * @param symbol   'X' or 'O' to place
     */
    private static void placeMove(char[][] board, String position, char symbol) {
        int cell = Integer.parseInt(position);
        int row  = (cell - 1) / 3;
        int col = (cell - 1) % 3;
        board[row][col] = symbol;
    }

    /**
     * Prints the current board to the console.
     *
     * @param board current 3*3 grid
     */
    private static void printBoard(char[][] board) {
        System.out.println();
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }
}
