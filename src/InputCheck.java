import java.util.Scanner;

public class InputCheck {

    static void inputRequest(String[][] board, Scanner sc, int numberFrom, int letterFrom, int numberTo, int letterTo) {
        System.out.println("Player one's turn (example [From: 2a] [To: 4A])");

        System.out.print("From: ");
        String inputFrom = sc.nextLine().toLowerCase();

        System.out.print("To: ");
        String inputTo = sc.nextLine().toLowerCase();

        processInput(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
    }

    static void invalidEntry(String[][] board, String inputFrom, String inputTo, Scanner sc, int numberFrom, int letterFrom, int numberTo, int letterTo) {
        System.out.println("Invalid entry, please try again");

        System.out.print("From: ");
        inputFrom = sc.nextLine().toLowerCase();

        System.out.print("To: ");
        inputTo = sc.nextLine().toLowerCase();

        processInput(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
    }

    static void processInput(String[][] board, String inputFrom, String inputTo, Scanner sc, int numberFrom, int letterFrom, int numberTo, int letterTo) {

        numberFrom = inputFrom.charAt(0) - 49;
        letterFrom = inputFrom.charAt(1) - 97;

        numberTo = inputTo.charAt(0) - 49;
        letterTo = inputTo.charAt(1) - 97;

        if (numberFrom > 7 || numberFrom < 0 || letterFrom > 7 || letterFrom < 0) {
            invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
        }
        if (numberTo > 7 || numberTo < 0 || letterTo > 7 || letterTo < 0) {
            invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
        }
        if (inputFrom.length() > 2 || inputTo.length() > 2) {
            invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
        }
        if (inputFrom.equals(inputTo)) {
            invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
        }

        Pieces.rules(board, numberFrom, letterFrom, numberTo, letterTo, inputFrom, inputTo, sc);
    }

}
