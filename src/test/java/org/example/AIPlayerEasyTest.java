package org.example;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class AIPlayerEasyTest {

    @Test
    public void testMakeMove() {
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        Random fixedRandom = new Random(0);
        AIPlayerEasy ai = new AIPlayerEasy('O', fixedRandom);
        ai.makeMove(board);

        int countO = 0;
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == 'O') {
                    countO++;
                }
            }
        }
        assertEquals(1, countO);
    }
}
