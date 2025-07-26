package org.example;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class tracks and logs the results of Tic-Tac-Toe games within a session.
 * It records the number of wins for X and O, the number of ties, and can print
 * or save the result to a file.
 */
public class GameLog {
    /** Counter for number of games won by X. */
    private int xWins = 0;
    /** Counter for number of games won by O. */
    private int oWins = 0;
    /** Counter for number of games that ended in a tie. */
    private int ties = 0;
    /** StringBuilder used to accumulate a session log for printing or saving. */
    private final StringBuilder logBuilder = new StringBuilder();

    /**
     * Constructs a new GameLog and initializes the session header.
     */
    public GameLog() {
        logBuilder.append("Tic-Tac-Toe Game Log\n\n");
    }

    /**
     * Records the result of a game and updates the log.
     * @param winner "X", "O", or "Tie"
     */
    public void recordResult(String winner) {
        // Update counters
        if ("X".equals(winner)) xWins++;
        else if ("O".equals(winner)) oWins++;
        else ties++;
        // Append current statistics to the session log
        logBuilder.append("After game ").append(totalGames()).append(":\n");
        logBuilder.append("Player X Wins   ").append(xWins).append("\n");
        logBuilder.append("Player O Wins   ").append(oWins).append("\n");
        logBuilder.append("Ties            ").append(ties).append("\n\n");
    }

    /**
     * Prints the current game statistics to the console.
     */
    public void printCurrentStats() {
        System.out.println("Player X Wins   " + xWins);
        System.out.println("Player O Wins   " + oWins);
        System.out.println("Ties            " + ties);
        System.out.println();
    }

    /**
     * Saves the log to a specified file.
     * @param filename the name of the file to write
     */
    public void saveToFile(String filename) {
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write(logBuilder.toString());
        } catch (IOException e) {
            System.out.println("Error writing log: " + e.getMessage());
        }
    }

    /**
     * Returns the total number of games played in this session.
     * @return total games played
     */
    public int totalGames() {
        return xWins + oWins + ties;
    }
}
