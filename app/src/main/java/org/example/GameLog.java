package org.example;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is about the game log, it is
 * responsible for keeping track of wins for each player and ties
 * during a Tic-Tac-Toe game process.
 * It can print current statistics, record each round, and save the full log to disk.
 */
public class GameLog {
    // Number of wins for Player X
    private int xWins = 0;
    // Number of wins for Player O
    private int oWins = 0;
    // Number of tie games
    private int ties = 0;
    // StringBuilder to get the log output
    private final StringBuilder logBuilder = new StringBuilder();

    /**
     * Constructs a new GameLog and initializes the log with a title.
     */
    public GameLog() {
        logBuilder.append("Tic-Tac-Toe Game Log\n\n");
    }

    /**
     * Records the result of a round and updates the game log.
     *
     * @param winner "X", "O", or "Tie"
     */
    public void recordResult(String winner) {
        if ("X".equals(winner)) xWins++;
        else if ("O".equals(winner)) oWins++;
        else ties++;
        logBuilder.append("After game ").append(totalGames()).append(":\n");
        logBuilder.append("Player X Wins   ").append(xWins).append("\n");
        logBuilder.append("Player O Wins   ").append(oWins).append("\n");
        logBuilder.append("Ties            ").append(ties).append("\n\n");
    }

    /**
     * Prints the current number of wins and ties to the console.
     */
    public void printCurrentStats() {
        System.out.println("Player X Wins   " + xWins);
        System.out.println("Player O Wins   " + oWins);
        System.out.println("Ties            " + ties);
        System.out.println();
    }

    /**
     * Saves the full game log to a file with the given filename.
     *
     * @param filename the name of the file to save the game log
     */
    public void saveToFile(String filename) {
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write(logBuilder.toString());
            System.out.println("(Saved successfully!)");
        } catch (IOException e) {
            System.out.println("Error writing log: " + e.getMessage());
        }
    }

    /**
     * @return The total number of games played
     */
    public int totalGames() {
        return xWins + oWins + ties;
    }
}