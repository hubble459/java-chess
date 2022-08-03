import java.util.Scanner;

public class Pieces {
    static void places(String[][] board) {
        // Rooks
        board[0][0] = "1R";
        board[0][7] = "1R";
        board[7][0] = "2R";
        board[7][7] = "2R";

        // Horses
        board[0][1] = "1H";
        board[0][6] = "1H";
        board[7][1] = "2H";
        board[7][6] = "2H";

        // Bishops
        board[0][2] = "1B";
        board[0][5] = "1B";
        board[7][2] = "2B";
        board[7][5] = "2B";

        // Queens
        board[0][3] = "1Q";
        board[7][3] = "2Q";

        // Kings
        board[0][4] = "1K";
        board[7][4] = "2K";

        // Pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = "1P";
            board[6][i] = "2P";
        }

        // Empty spots
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = "  ";
            }
        }

        //pp
        board[2][4] = "1K";

    }

    static void rules(String[][] board, int numberFrom, int letterFrom, int numberTo, int letterTo, String inputFrom, String inputTo, Scanner sc) {
        switch (board[numberFrom][letterFrom]) {
            case "1P": // Pawn
                if (numberFrom == 1) { // First turn with a pawn gets a maximum of two jumps
                    if (numberTo > numberFrom + 2) {
                        InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                        return;
                    }

                    // Making sure you can't jump over a pawn
                    if ((!board[numberTo - 1][letterTo].equals("  ") && letterFrom == letterTo) && numberTo == numberFrom + 2) {
                        InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                        return;
                    }

                } else if (numberTo > numberFrom + 1) { // Can't move two spots at a time
                    InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                    return;
                }

                // Diagonally take an evil piece
                if (board[numberTo][letterTo].charAt(0) == '2' && (letterFrom == letterTo + 1 || letterFrom == letterTo - 1)) {
                    board[numberTo][letterTo] = "1P";
                    board[numberFrom][letterFrom] = "  ";
                } else if (!board[numberTo][letterTo].equals("  ")) {
                    InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                    return;
                }

                board[numberTo][letterTo] = "1P";
                board[numberFrom][letterFrom] = "  ";
                break;


            case "1R": // Rook
                if (numberFrom != numberTo && letterFrom != letterTo) {
                    InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                    return;
                }

                if (numberFrom == numberTo) {
                    int m = letterFrom + 1;
                    int n = letterFrom - 1;
                    while (m < letterTo) {
                        if (!board[numberFrom][m++].equals("  ")) {
                            InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                            return;
                        }
                    }
                    while (n > letterTo) {
                        if (!board[numberFrom][n--].equals("  ")) {
                            InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                            return;
                        }
                    }
                }

                if (letterFrom == letterTo) {
                    int i = numberFrom + 1;
                    while (i < numberTo) {
                        if (!board[i][letterFrom].equals("  ")) {
                            InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                            return;
                        }
                        i++;
                    }
                }

                if (board[numberTo][letterTo].charAt(0) == '1') {
                    InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                    return;
                }

                board[numberTo][letterTo] = "1R";
                board[numberFrom][letterFrom] = "  ";
                break;

            case "1H": // Horse
                if ((numberTo == numberFrom + 2 && letterTo == letterFrom + 1) || (numberTo == numberFrom + 2 && letterTo == letterFrom - 1) ||
                    (numberTo == numberFrom - 2 && letterTo == letterFrom + 1) || (numberTo == numberFrom - 2 && letterTo == letterFrom - 1) ||
                    (numberTo == numberFrom + 1 && letterTo == letterFrom + 2) || (numberTo == numberFrom - 1 && letterTo == letterFrom + 2) ||
                    (numberTo == numberFrom + 1 && letterTo == letterFrom - 2) || (numberTo == numberFrom - 1 && letterTo == letterFrom - 2)) {

                    if (board[numberTo][letterTo].charAt(0) == '1') {
                        InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                        return;
                    }

                    board[numberTo][letterTo] = "1H";
                    board[numberFrom][letterFrom] = "  ";

                } else {
                    InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                    return;
                }

                break;

            case "1B": // Bishop
                if (numberTo == numberFrom || letterTo == letterFrom) {
                    InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                    return;
                }

                if (board[numberTo][letterTo].charAt(0) == '1') {
                    InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                    return;
                }

                int i = letterFrom + 1;
                int j = numberFrom + 1;
                int k = letterFrom - 1;
                int l = numberFrom - 1;

                while (i < letterTo && j < numberTo) {
                    if (!board[j++][i++].equals("  ")) {
                        InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                        return;
                    }
                }
                while (k > letterTo && j < numberTo) {
                    if (!board[j++][k--].equals("  ")) {
                        InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                        return;
                    }
                }
                while (k > letterTo && j > numberTo) {
                    if (!board[l--][k--].equals("  ")) {
                        InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                        return;
                    }
                }
                while (i < letterTo && j > numberTo) {
                    if (!board[j++][i--].equals("  ")) {
                        InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                        return;
                    }
                }

                board[numberTo][letterTo] = "1B";
                board[numberFrom][letterFrom] = "  ";
                break;

            case "1Q": // Queen
                if (board[numberTo][letterTo].charAt(0) == '1') {
                    InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                    return;
                }

                //numberFrom, numberTo, letterFrom, letterTo
                if (numberFrom - numberTo > 0) {}
                if (!board[numberFrom + 1][letterFrom + 1].equals("  ")) { InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo); return; }


                board[numberTo][letterTo] = "1Q";
                board[numberFrom][letterFrom] = "  ";
                break;

            case "1K": // King
                if (board[numberTo][letterTo].charAt(0) == '1') {
                    InputCheck.invalidEntry(board, inputFrom, inputTo, sc, numberFrom, letterFrom, numberTo, letterTo);
                    return;
                }

                board[numberTo][letterTo] = "1K";
                board[numberFrom][letterFrom] = "  ";

        }
    }
}