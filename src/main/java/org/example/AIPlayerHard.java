package org.example;

public class AIPlayerHard implements Player {
    private static final int MAX_INPUT_VALUE = 3;
    private static final int SCORE_WIN = 10;
    private static final int SCORE_LOSS = -10;
    private static final int SCORE_DRAW = 0;


    private final char symbol;

    public AIPlayerHard(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void makeMove(final char[][] board) {
        System.out.println("Making move level \"hard\"");
        int bestScore = Integer.MIN_VALUE;
        int coordX = -1;
        int coordY = -1;

        for (int i = 0; i < MAX_INPUT_VALUE; i++) {
            for (int j = 0; j < MAX_INPUT_VALUE; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = symbol;
                    int score = minimax(board, 0, false);
                    board[i][j] = ' ';
                    if (score > bestScore) {
                        bestScore = score;
                        coordX = i;
                        coordY = j;
                    }
                }
            }
        }
        board[coordX][coordY] = symbol;
    }

    private int minimax(final char[][] board, final int depth,
                        final boolean isMaximizing) {
        char opponent;
        opponent = (symbol == 'X') ? 'O' : 'X';

        String result = evaluateBoard(board);
        if (result != null) {
            switch (result) {
                case "win":
                    return SCORE_WIN - depth;
                case "lose":
                    return SCORE_LOSS + depth;
                case "draw":
                    return SCORE_DRAW;
                default:
                    return 0;
            }
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < MAX_INPUT_VALUE; i++) {
                for (int j = 0; j < MAX_INPUT_VALUE; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = symbol;
                        int score = minimax(board, depth + 1, false);
                        board[i][j] = ' ';
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < MAX_INPUT_VALUE; i++) {
                for (int j = 0; j < MAX_INPUT_VALUE; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = opponent;
                        int score = minimax(board, depth + 1, true);
                        board[i][j] = ' ';
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    private String evaluateBoard(final char[][] board) {
        for (int i = 0; i < MAX_INPUT_VALUE; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1]
                    && board[i][1] == board[i][2]) {
                return (board[i][0] == symbol) ? "win" : "lose";
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i]
                    && board[1][i] == board[2][i]) {
                return (board[0][i] == symbol) ? "win" : "lose";
            }
        }

        if (board[0][0] != ' ' && board[0][0] == board[1][1]
                && board[1][1] == board[2][2]) {
            return (board[0][0] == symbol) ? "win" : "lose";
        }

        if (board[0][2] != ' ' && board[0][2] == board[1][1]
                && board[1][1] == board[2][0]) {
            return (board[0][2] == symbol) ? "win" : "lose";
        }

        boolean isFull = true;
        for (int i = 0; i < MAX_INPUT_VALUE; i++) {
            for (int j = 0; j < MAX_INPUT_VALUE; j++) {
                if (board[i][j] == ' ') {
                    isFull = false;
                    break;
                }
            }
        }

        if (isFull) {
            return "draw";
        }
        return null;
    }
}
