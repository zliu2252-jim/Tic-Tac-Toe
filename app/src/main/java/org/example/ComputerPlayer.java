package org.example;

import java.util.Objects;
import java.util.Random;

/**
 * This class implements an opportunistic computer player for Tic-Tac-Toe.
 * The computer chooses its move based on a prioritized strategy:
 *  a. Take a random corner if it's the first move.
 *  b. Take the center if it's the second move and available.
 *  c. Win if possible.
 *  d. Block the opponent from winning.
 *  e. Otherwise, pick a random available spot.
 */
public class ComputerPlayer {
    /** The shared board array used by the game. */
    String[][] board;

    /** The Board object for the array. */
    Board boardSetup;

    /** Reference to the Rules object for win/block checking. */
    Rules rules;

    /** The symbol for this computer player. */
    String symbol;

    /** Used to generate random moves among available spaces. */
    Random rand = new Random();

    /**
     * Constructs the new ComputerPlayer.
     * @param inBoard      The board array for the game.
     * @param playerSymbol The symbol assigned to this computer player.
     * @param inBoardSetup The Board object reference.
     * @param rules        The Rules object for win/block checking.
     */
    public ComputerPlayer(String[][] inBoard, String playerSymbol, Board inBoardSetup, Rules rules) {
        board = inBoard;
        symbol = playerSymbol;
        boardSetup = inBoardSetup;
        this.rules = rules;
    }

    /**
     * Makes the computer's move using a prioritized strategy.
     */
    public void move() {
        int emptyCount = countEmptyCells();
        // First move of the game
        if (emptyCount == 9) {
            firstMove();
            return;
        }
        // Second move, center available
        if (emptyCount == 8 && Objects.equals(board[1][1], "  5  ")) {
            board[1][1] = symbol;
            return;
        }
        // Win if possible
        if (winCheck()) return;
        // Block opponent if possible
        if (blockCheck()) return;
        // Otherwise, pick a random spot
        randomPosition();
    }

    /**
     * Counts how many empty cells remain on the board.
     * @return the number of empty cells
     */
    private int countEmptyCells() {
        int emptyCount = 0;
        for (String[] row : board) {
            for (String cell : row) {
                if (!cell.equals("  X  ") && !cell.equals("  O  ")) {
                    emptyCount++;
                }
            }
        }
        return emptyCount;
    }

    /**
     * Handles the first move of the game, placing a mark in a random corner.
     */
    private void firstMove() {
        int[][] corners = {{0,0},{0,2},{2,0},{2,2}};
        int[] move = corners[rand.nextInt(4)];
        board[move[0]][move[1]] = symbol;
    }

    /**
     * Checks if the computer can win by making a move, and makes that move if possible.
     * @return true if a winning move was made, false otherwise
     */
    public boolean winCheck() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Try placing the symbol in each empty spot and check for win
                if (!board[i][j].equals("  X  ") && !board[i][j].equals("  O  ")) {
                    String old = board[i][j];
                    board[i][j] = symbol;
                    if (rules.hasContestantWon(board, symbol)) {
                        return true;
                    }
                    board[i][j] = old;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the opponent can win by making a move, and blocks that move if possible.
     * @return true if a block was made, false otherwise
     */
    public boolean blockCheck() {
        String opponent;
        // Determine the opponent's symbol
        if (symbol.equals("  X  ")) {
            opponent = "  O  ";
        } else {
            opponent = "  X  ";
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Try placing the opponent's symbol in each empty spot and check for win
                if (!board[i][j].equals("  X  ") && !board[i][j].equals("  O  ")) {
                    String old = board[i][j];
                    board[i][j] = opponent;
                    if (rules.hasContestantWon(board, opponent)) {
                        board[i][j] = symbol;
                        return true;
                    }
                    board[i][j] = old;
                }
            }
        }
        return false;
    }

    /**
     * Picks a random available position on the board and places the computer's symbol.
     */
    void randomPosition() {
        int[][] emptyPositions = new int[9][2];
        int emptyCount = 0;
        // Collect all empty positions on the board
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (!board[i][j].equals("  X  ") && !board[i][j].equals("  O  ")) {
                    emptyPositions[emptyCount][0] = i;
                    emptyPositions[emptyCount][1] = j;
                    emptyCount++;
                }
            }
        }
        // Choose a random empty position
        int[] pos = emptyPositions[rand.nextInt(emptyCount)];
        board[pos[0]][pos[1]] = symbol;
    }
}