import java.util.Scanner;

public class Chess {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] board = new String[8][8];

        int[] sideLines = {1,2,3,4,5,6,7,8};

        int numberFrom = 0, letterFrom = 0, numberTo = 0, letterTo = 0;

        Pieces.places(board);

        while (true) {
            Board.boardPrinter(board, sideLines);

            InputCheck.inputRequest(board, sc, numberFrom, letterFrom, numberTo, letterTo);

            Board.boardPrinter(board, sideLines);
        }
    }
}