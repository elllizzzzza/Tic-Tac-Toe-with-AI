public class Game {
    private static char[][] board = new char[3][3];

    public Game() {
        this.board = board;
    }

    public Game(char[][] board) {
        this.board = board;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }



    public String checkWin(){
        for(int i = 0; i < 3; i++){
            if((board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) ||
                    (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i])
            ) return board[i][0] + " wins";
        }

        if ((board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
        ) return board[1][1] + " wins";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return "Game not finished";
            }
        }
        return "Draw";
    }


    public void initializeEmptyBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }


    public void printBoard(){
        System.out.println("---------");
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("| ");
        }
        System.out.println("---------");
    }

}
