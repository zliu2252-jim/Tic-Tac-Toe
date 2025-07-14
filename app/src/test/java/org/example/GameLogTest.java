package org.example;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the GameLog class, which tracks wins, ties, and handles log saving.
 */
class GameLogTest {

    /**
     * Tests recording a win for Player X.
     */
    @Test
    void testRecordXWin() {
        GameLog log = new GameLog();
        log.recordResult("X");
        assertEquals(1, log.totalGames());
    }

    /**
     * Tests recording a win for Player O.
     */
    @Test
    void testRecordOWin() {
        GameLog log = new GameLog();
        log.recordResult("O");
        assertEquals(1, log.totalGames());
    }

    /**
     * Tests recording a tie.
     */
    @Test
    void testRecordTie() {
        GameLog log = new GameLog();
        log.recordResult("Tie");
        assertEquals(1, log.totalGames());
    }

    /**
     * Tests saving the log to a file, ensures file is created and the file is not empty
     */
    @Test
    void testSaveToFile() {
        GameLog log = new GameLog();
        log.recordResult("X");
        log.saveToFile("test_gamelog.txt");
        File file = new File("test_gamelog.txt");
        assertTrue(file.exists());
        assertTrue(file.length() > 0);
        file.delete();
    }
}