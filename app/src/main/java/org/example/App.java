package org.example;

import java.util.Scanner;

/**
 * This class is the main driver for the console-based Tic-Tac-Toe game.
 * It manages the game loop, player order, result logging, and handles
 * replay prompts and save the file for the game log.
 */
public class App {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");

        // GameLog keeps track of X wins, O wins, and ties for the session.
        GameLog log = new GameLog();
        // Tracks which player starts first in each round.
        char firstPlayer = 'X', secondPlayer = 'O';

        // This loop continues playing games until the user chooses to exit.
        do {
            // Initialize a new board for current round.
            Board board = new Board();
            if (log.totalGames() > 0) {
                System.out.println("\nGreat! This time " + firstPlayer + " will go first!\n");
            }
            board.printBoard();

            char currentPlayer = firstPlayer;
            char otherPlayer = secondPlayer;
            boolean roundOver = false;
            String winner = null;

            // This loop alternates turns until the round ends (win or tie).
            while (!roundOver) {
                Player.playerMove(board, scnr, currentPlayer);
                if (Rules.isGameFinished(board)) {
                    // When the game finished, print appropriate message and track winner or tie.
                    if (Rules.hasContestantWon(board, currentPlayer)) {
                        System.out.println("Player " + currentPlayer + " wins! The current log is:\n");
                        winner = String.valueOf(currentPlayer);
                    } else {
                        System.out.println("The game ended in a tie! The current log is:\n");
                        winner = "Tie";
                    }
                    roundOver = true;
                    break;
                }
                board.printBoard();

                //Swap current player for the next turn.
                char temp = currentPlayer;
                currentPlayer = otherPlayer;
                otherPlayer = temp;
            }

            // Update the log with the outcome and print current statistics.
            log.recordResult(winner);
            log.printCurrentStats();

            // Loser goes first, swap if the game is a tie.
            if (!"Tie".equals(winner)) {
                if ("X".equals(winner)) {
                    firstPlayer = 'O'; secondPlayer = 'X';
                } else {
                    firstPlayer = 'X'; secondPlayer = 'O';
                }
            } else {
                char tmp = firstPlayer;
                firstPlayer = secondPlayer;
                secondPlayer = tmp;
            }
        } while (PlayAgain.askPlayAgain(scnr));

        // After users choose not to play the game, write the game log to disk.
        System.out.println("\nWriting the game log to disk. Please see game.txt for the final statistics!");
        log.saveToFile("game.txt");

        System.out.println("Goodbye!");
        scnr.close();
    }
}
