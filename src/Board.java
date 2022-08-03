public class Board {
    static void boardPrinter(String[][] board, int[] sideLines) {
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        for (int i = 7; i >= 0; i--) {
            System.out.print(sideLines[i] + " ");
            for (String A: board[i]) { System.out.print("│ "); System.out.print(A + " "); }
            System.out.print("|");
            System.out.println();
            System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        }
        System.out.println("    A    B    C    D    E    F    G    H");
        System.out.println();
    }
}
