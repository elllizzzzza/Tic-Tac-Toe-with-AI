import java.util.Random;

public class AIPlayerEasy implements Player{
    private char symbol;


    public AIPlayerEasy(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void makeMove(char[][] board) {
        int x, y;
        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (board[x][y] != ' ');

        board[x][y] = symbol;
    }
}
