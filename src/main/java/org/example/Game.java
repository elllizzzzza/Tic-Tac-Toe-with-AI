package org.example;

public class Game {
    private static final int MAX_INPUT_VALUE = 3;
    private static char[][] board = new char[MAX_INPUT_VALUE][MAX_INPUT_VALUE];

    public Game() {
        board = board;
    }

    public Game(char[][] board) {
        Game.board = board;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        Game.board = board;
    }

    public String checkWin() {
        for (int i = 0; i < MAX_INPUT_VALUE; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1]
                    && board[i][1] == board[i][2]) {
                return board[i][0] + " wins";
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i]
                    && board[1][i] == board[2][i]) {
                return board[0][i] + " wins";
            }
        }

        if (board[0][0] != ' ' && board[0][0] == board[1][1]
                && board[1][1] == board[2][2]
                || board[0][2] != ' ' && board[0][2] == board[1][1]
                && board[1][1] == board[2][0]) {
            return board[1][1] + " wins";
        }

        for (int i = 0; i < MAX_INPUT_VALUE; i++) {
            for (int j = 0; j < MAX_INPUT_VALUE; j++) {
                if (board[i][j] == ' ') {
                    return "Game not finished";
                }
            }
        }
        return "Draw";
    }

    public void initializeEmptyBoard() {
        for (int i = 0; i < MAX_INPUT_VALUE; i++) {
            for (int j = 0; j < MAX_INPUT_VALUE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < MAX_INPUT_VALUE; i++) {
            System.out.print("| ");
            for (int j = 0; j < MAX_INPUT_VALUE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("| ");
        }
        System.out.println("---------");
    }
}
