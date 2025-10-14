package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AiPlayerMediumTest {
    AiPlayerMedium ai;

    @BeforeEach
    public void setUp(){
        ai = new AiPlayerMedium('X');
    }

    @Test
    public void testAiMediumMakesWinLine1() {
        char[][] board = {
                {'X', 'X', ' '},
                {'O', ' ', ' '},
                {' ', ' ', 'O'}
        };
        ai.makeMove(board);
        assertEquals('X', board[0][2]);
    }

    @Test
    public void testAiMediumMakesWinLine2() {
        char[][] board = {
                {'X', ' ', 'X'},
                {'O', ' ', ' '},
                {' ', ' ', 'O'}
        };
        ai.makeMove(board);
        assertEquals('X', board[0][1]);
    }

    @Test
    public void testAiMediumMakesWinLine3() {
        char[][] board = {
                {' ', 'X', 'X'},
                {'O', ' ', ' '},
                {' ', ' ', 'O'}
        };
        ai.makeMove(board);
        assertEquals('X', board[0][0]);
    }

    @Test
    public void testAiMediumMakesWinDiagonal1() {
        char[][] board = {
                {'X', ' ', ' '},
                {'O', 'X', ' '},
                {' ', 'O', ' '}
        };
        ai.makeMove(board);
        assertEquals('X', board[2][2]);
    }

    @Test
    public void testAiMediumMakesWinDiagonal2() {
        char[][] board = {
                {'X', ' ', ' '},
                {'O', ' ', ' '},
                {' ', 'O', 'X'}
        };
        ai.makeMove(board);
        assertEquals('X', board[1][1]);
    }

    @Test
    public void testAiMediumMakesWinDiagonal3() {
        char[][] board = {
                {' ', ' ', ' '},
                {'O', 'X', ' '},
                {' ', 'O', 'X'}
        };
        ai.makeMove(board);
        assertEquals('X', board[0][0]);
    }

    @Test
    public void testAiMediumMakesWinDiagonalR1() {
        char[][] board = {
                {' ', ' ', 'X'},
                {'O', 'X', ' '},
                {' ', 'O', ' '}
        };
        ai.makeMove(board);
        assertEquals('X', board[2][0]);
    }

    @Test
    public void testAiMediumMakesWinDiagonalR2() {
        char[][] board = {
                {' ', ' ', 'X'},
                {'O', ' ', ' '},
                {'X', 'O', ' '}
        };
        ai.makeMove(board);
        assertEquals('X', board[1][1]);
    }

    @Test
    public void testAiMediumMakesWinDiagonalR3() {
        char[][] board = {
                {' ', ' ', ' '},
                {'O', 'X', ' '},
                {'X', 'O', ' '}
        };
        ai.makeMove(board);
        assertEquals('X', board[0][2]);
    }

    @Test
    public void testAiMediumMakesWinHorizontal() {
        char[][] board = {
                {'X', ' ', 'O'},
                {' ', ' ', ' '},
                {'X', 'O', ' '}
        };
        ai.makeMove(board);
        assertEquals('X', board[1][0]);
    }

    @Test
    public void testAIMediumMakesBlock() {
        char[][] board = {
                {'X', ' ', 'X'},
                {' ', 'O', ' '},
                {' ', 'O', ' '}
        };

        ai.makeMove(board);

        assertEquals('X', board[0][1]);
    }

    @Test
    public void testAiMediumMakesRandom(){
        char[][] board = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {' ', ' ', ' '}
        };

        AiPlayerMedium ai = new AiPlayerMedium('X');
        ai.makeMove(board);

        int countX = 0;
        for (char[] row : board) {
            for (char c : row) {
                if (c == 'X') countX++;
            }
        }
        assertEquals(4, countX);
    }

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

    @Test
    public void testAiPrefersWinOverBlock() {
        char[][] board = {
                {'X', 'X', ' '},
                {'O', 'O', ' '},
                {' ', ' ', ' '}
        };

        ai.makeMove(board);

        assertEquals('X', board[0][2]);
    }

    @Test
    public void testAiFallbackMove() {
        char[][] board = {
                {'X', 'O', 'X'},
                {'X', 'O', 'O'},
                {'O', 'X', ' '}
        };
        ai.makeMove(board);
        assertEquals('X', board[2][2]);
    }
}