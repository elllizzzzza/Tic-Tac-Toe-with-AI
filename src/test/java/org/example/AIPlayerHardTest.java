package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AIPlayerHardTest {
    AIPlayerHard ai;

    @BeforeEach
    public void setUp() {
        ai = new AIPlayerHard('X');
    }

    @Test
    public void testAIHardMakesMove() {
        char[][] board = {
                {'X', 'O', 'X'},
                {' ', 'O', ' '},
                {' ', ' ', ' '}
        };

        ai.makeMove(board);

        int countX = 0;
        for (char[] row : board) {
            for (char c : row) {
                if (c == 'X') countX++;
            }
        }

        assertEquals(3, countX);
    }

    @Test
    public void testAIHardMakesWin() {
        char[][] board = {
                {'X', ' ', 'X'},
                {' ', 'O', ' '},
                {' ', ' ', 'O'}
        };

        ai.makeMove(board);

        assertEquals('X', board[0][1]);
    }

    @Test
    public void testAIHardMakesBlock() {
        char[][] board = {
                {'X', ' ', 'X'},
                {' ', 'O', ' '},
                {' ', 'O', ' '}
        };

        ai.makeMove(board);

        assertEquals('X', board[0][1]);
    }
}