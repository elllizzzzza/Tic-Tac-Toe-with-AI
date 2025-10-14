package org.example;

import java.util.Random;

public class AIPlayerEasy implements Player {
    private static final int MAX_INPUT_VALUE = 3;
    private final char symbol;
    Random random;

    public AIPlayerEasy(char symbol, Random random) {
        this.symbol = symbol;
        this.random = random;
    }

    @Override
    public void makeMove(char[][] board) {
        int x, y;
        System.out.println("Making move level \"easy\"");
        do {
            x = random.nextInt(MAX_INPUT_VALUE);
            y = random.nextInt(MAX_INPUT_VALUE);
        } while (board[x][y] != ' ');

        board[x][y] = symbol;
    }
}
