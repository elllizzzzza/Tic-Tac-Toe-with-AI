import java.util.Scanner;

public class UserPlayer implements Player{
    private char symbol;
    private static final Scanner scanner = new Scanner(System.in);

    public UserPlayer(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void makeMove(char[][] board) {
        int[] coord = enterCoordinates();
        int x = coord[0];
        int y = coord[1];
        while (board[x-1][y-1] != ' '){
            System.out.println("This cell is occupied! Choose another one!");
            coord = enterCoordinates();
            x = coord[0];
            y = coord[1];
        }
        board[x-1][y-1] = symbol;
    }

    public static int[] enterCoordinates() {
        int[] coord = new int[2];

        boolean valid = false;
        int x, y;

        while (!valid) {
            System.out.println("Enter the coordinates: >");
            try {
                x = scanner.nextInt();
                y = scanner.nextInt();
                if (!((x > 0 && x < 4) && (y > 0 && y < 4))) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    valid = true;
                    coord[0] = x;
                    coord[1] = y;
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
        }
        return coord;
    }
}
