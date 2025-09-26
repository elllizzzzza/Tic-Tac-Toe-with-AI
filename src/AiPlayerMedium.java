import java.util.Random;

public class AiPlayerMedium implements Player {
    private char symbol;

    public AiPlayerMedium(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void makeMove(char[][] board) {
        System.out.println("Making move level \"medium\"");

        if (tryToWinOrBlock(board, symbol)) return;

        char opponent;
        opponent = (symbol == 'X') ? 'O' : 'X';
        if (tryToWinOrBlock(board, opponent)) return;

        fallbackMove(board);
    }

    private boolean tryToWinOrBlock(char[][] board, char s) {
        for (int i = 0; i < 3; i++) {

            if (checkLine(board[i][0], board[i][1], board[i][2], s)) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = symbol;
                        return true;
                    }
                }
            }

            if (checkLine(board[0][i], board[1][i], board[2][i], s)) {
                for (int j = 0; j < 3; j++) {
                    if (board[j][i] == ' ') {
                        board[j][i] = symbol;
                        return true;
                    }
                }
            }
        }

        if (checkLine(board[0][0], board[1][1], board[2][2], s)) {
            if (board[0][0] == ' ') {
                board[0][0] = symbol;
                return true;
            }

            if (board[1][1] == ' '){
                board[1][1] = symbol;
                return true;
            }

            if (board[2][2] == ' '){
                board[2][2] = symbol;
                return true;
            }
        }

        if (checkLine(board[0][2], board[1][1], board[2][0], s)) {
            if (board[0][2] == ' '){
                board[0][2] = symbol;
                return true;
            }

            if (board[1][1] == ' ') {
                board[1][1] = symbol;
                return true;
            }

            if (board[2][0] == ' ') {
                board[2][0] = symbol;
                return true;
            }
        }

        return false;
    }

    private boolean checkLine(char a, char b, char c, char s) {
        int countS = 0;
        int countEmpty = 0;

        if (a == s) countS++;
        else if (a == ' ') countEmpty++;

        if (b == s) countS++;
        else if (b == ' ') countEmpty++;

        if (c == s) countS++;
        else if (c == ' ') countEmpty++;

        return countS == 2 && countEmpty == 1;
    }

    private void fallbackMove(char[][] board) {
        int x, y;
        Random random = new Random();
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (board[x][y] != ' ');

        board[x][y] = symbol;
    }
}