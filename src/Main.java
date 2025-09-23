import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        Player player1 = null, player2= null;

        boolean valid = false;
        while (!valid) {
            System.out.print("Input command: ");
            input = scanner.nextLine().trim();

            String[] parts = input.split("\\s+");

            if (parts[0].equals("exit")) {
                break;
            } else if (parts[0].equals("start")) {
                if (parts.length != 3) {
                    System.out.println("Bad parameters!");
                }else{
                    player1 = createPlayer(parts[1], 'X');
                    player2 = createPlayer(parts[2], 'O');

                    if (player1 == null || player2 == null) {
                        System.out.println("Bad parameters!");
                        continue;
                    }
                    valid = true;
                }
            }
        }


        Game game = new Game();
        game.initializeEmptyBoard();
        game.printBoard();

        boolean turn1 = true;
        while (game.checkWin().equals("Game not finished")) {
            if (turn1){
                player1.makeMove(game.getBoard());
                game.printBoard();
                turn1 = false;
            } else {
                player2.makeMove(game.getBoard());
                game.printBoard();
                turn1 = true;
            }
        }
        System.out.println(game.checkWin());
    }


    public static Player createPlayer(String type, char symbol) {
        switch (type.toLowerCase()) {
            case "user":
                return new UserPlayer(symbol);
            case "easy":
                return new AIPlayerEasy(symbol);
            case "medium":
                return new AiPlayerMedium(symbol);
            case "hard":
                return new AIPlayerHard(symbol);
            default:
                System.out.println("No such type of player. ");
                return null;
        }
    }
}