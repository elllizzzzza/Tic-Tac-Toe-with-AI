package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
    private Game game;

    @BeforeEach
    public void setUp(){
        game = new Game();
        game.initializeEmptyBoard();
    }

    @Test
    void testNotFinished() {
        assertEquals("Game not finished", game.checkWin());
    }

    @Test
    public void testRowWinX(){
        char[][] board = {
                {'X', 'X', 'X'},
                {'O', ' ', ' '},
                {' ', 'O', ' '}
        };
        game.setBoard(board);
        assertEquals("X wins", game.checkWin());
    }

    @Test
    public void testColumnWinO(){
        char[][] board = {
                {'X', 'O', 'X'},
                {'X', 'O', ' '},
                {' ', 'O', ' '}
        };
        game.setBoard(board);
        assertEquals("O wins", game.checkWin());
    }

    @Test
    public void testDiagonal2WinO(){
        char[][] board = {
                {'X', 'X', 'O'},
                {'X', 'O', ' '},
                {'O', ' ', ' '}
        };
        game.setBoard(board);
        assertEquals("O wins", game.checkWin());
    }

    @Test
    public void testDiagonal1WinX(){
        char[][] board = {
                {'X', 'O', 'O'},
                {'X', 'X', ' '},
                {'O', ' ', 'X'}
        };
        game.setBoard(board);
        assertEquals("X wins", game.checkWin());
    }

    @Test
    public void testDraw(){
        char[][] board = {
                {'X', 'O', 'X'},
                {'X', 'X', 'O'},
                {'O', 'X', 'O'}
        };
        game.setBoard(board);
        assertEquals("Draw", game.checkWin());
    }


    @Test
    public void testPrintBoardOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        char[][] board = {
                {'X', 'O', 'X'},
                {' ', 'X', 'O'},
                {'O', ' ', ' '}
        };
        game = new Game(board);
        game.printBoard();

        String expectedOutput =
                """
                        ---------
                        | X O X |\s
                        |   X O |\s
                        | O     |\s
                        ---------
                        """;
        assertEquals(expectedOutput, outContent.toString());
    }
}
