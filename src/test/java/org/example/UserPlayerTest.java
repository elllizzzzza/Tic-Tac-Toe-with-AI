package org.example;

import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UserPlayerTest {

    UserPlayer userPlayer;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private char[][] createEmptyBoard() {
        return new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
    }

    @Test
    void testOccupiedCellPromptsRetry() {
        String input = "1 1\n2 2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));

        UserPlayer player = new UserPlayer('O');
        char[][] board = createEmptyBoard();
        board[0][0] = 'X';
        player.makeMove(board);

        assertEquals('O', board[1][1]);
        String output = outContent.toString();
        assertTrue(output.contains("This cell is occupied!"));
    }
}
