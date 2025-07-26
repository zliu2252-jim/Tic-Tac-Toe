package org.example;

import java.util.Scanner;

/**
 * This class is the main driver for the console-based Tic-Tac-Toe game.
 * It manages game setup, user prompts, the main game loop, player turns,
 * game results, and session replay.
 */
public class App {

    /**
     * Default no-argument constructor (used for testing).
     */
    public App() {}

    /**
     * Main entry point for the application.
     * Handles game mode selection, session logging, player order, and round loop.
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!\n");

        // Prompt the user for game mode
        int mode = getGameMode(scnr);
        // GameLog keeps track of wins and ties for the session.
        GameLog log = new GameLog();

        // Assign which player goes first, depending on the selected mode.
        char firstPlayer, secondPlayer;
        if (mode == 3) {
            firstPlayer = 'O'; // Computer goes first as O
            secondPlayer = 'X';
        } else {
            firstPlayer = 'X'; //Human goes first as X
            secondPlayer = 'O';
        }

        // The outer loop continues playing games until the user chooses to exit.
        do {
            // Initialize a new board for the current round.
            String[][] boardSetup = {
                    {"  1  ", "  2  ", "  3  "},
                    {"  4  ", "  5  ", "  6  "},
                    {"  7  ", "  8  ", "  9  "}
            };
            Board board = new Board(boardSetup);
            Rules rules = new Rules();
            Human humanX = new Human('X', board, scnr);
            Human humanO = new Human('O', board, scnr);
            ComputerPlayer computerX = new ComputerPlayer(boardSetup, "  X  ", board, rules);
            ComputerPlayer computerO = new ComputerPlayer(boardSetup, "  O  ", board, rules);

            // Display info if not the first game in the session.
            if (log.totalGames() > 0) {
                System.out.println("\nGreat! This time " + firstPlayer + " will go first.\n");
            }

            char currentPlayer = firstPlayer;
            char otherPlayer = secondPlayer;
            boolean roundOver = false;
            String winner = null;

            // Print initial board and let computer move if computer is first.
            if (mode == 3) {
                System.out.println("\nGreat! The computer will go first.\n");
                computerO.move();
                board.printBoard();
            } else {
                System.out.println();
                board.printBoard();
            }

            // Main game loop alternates player turns until a win or tie occurs.
            while (!roundOver) {
                // Determine if the current player is human or computer.
                boolean isHuman = (mode == 1) ||
                        (mode == 2 && currentPlayer == 'X') ||
                        (mode == 3 && currentPlayer == 'O');

                // Execute move for human or computer.
                if (isHuman) {
                    if (currentPlayer == 'X') humanX.move();
                    else humanO.move();
                } else {
                    if (currentPlayer == 'X') computerX.move();
                    else computerO.move();
                }
                board.printBoard();

                // Check if the game has ended, and set the winner or tie.
                if (rules.isGameFinished(board)) {
                    if (rules.hasContestantWon(board.board, currentPlayer == 'X' ? "  X  " : "  O  ")) {
                        System.out.println("Player " + currentPlayer + " wins!");
                        winner = String.valueOf(currentPlayer);
                    } else {
                        System.out.println("The game ended in a tie!");
                        winner = "Tie";
                    }
                    roundOver = true;
                    break;
                }

                // Swap currentPlayer for the next turn.
                char temp = currentPlayer;
                currentPlayer = otherPlayer;
                otherPlayer = temp;
            }

            // Update the log with the outcome.
            log.recordResult(winner);
            log.printCurrentStats();

            // Loser goes first next, or swap if tie
            if (!"Tie".equals(winner)) {
                if ("X".equals(winner)) {
                    firstPlayer = 'O';
                    secondPlayer = 'X';
                } else {
                    firstPlayer = 'X';
                    secondPlayer = 'O';
                }
            } else {
                char tmp = firstPlayer;
                firstPlayer = secondPlayer;
                secondPlayer = tmp;
            }
        } while (PlayAgain.askPlayAgain(scnr));

        // After all games are finished, print goodbye message.
        System.out.println("Goodbye!");
        scnr.close();
    }

    /**
     * Prompts the user for game mode selection and validates input.
     * @param scnr Scanner for user input
     * @return selected mode as an integer (1, 2, or 3)
     */
    private static int getGameMode(Scanner scnr) {
        System.out.println("What kind of game would you like to play?\n");
        System.out.println("1. Human vs. Human");
        System.out.println("2. Human vs. Computer");
        System.out.println("3. Computer vs. Human\n");
        System.out.print("What is your selection? ");
        int mode = 0;
        while (true) {
            String input = scnr.nextLine().trim();
            try {
                mode = Integer.parseInt(input);
                if (mode >= 1 && mode <= 3) break;
            } catch (NumberFormatException ignored) {}
            System.out.print("Please enter 1, 2, or 3: ");
        }
        if (mode == 2)
            System.out.println("\nYou will go first.\n");
        if (mode == 3)
            System.out.println();
        return mode;
    }
}
