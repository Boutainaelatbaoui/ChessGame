import entity.Board;

public class ChessGame {
    public static void main(String[] args) {

        System.out.println("\u001B[1m"); // Bold formatting
        System.out.println("****************************************");
        System.out.println("    \u001B[93m      CHESSMASTER - Welcome!      \u001B[0m   ");
        System.out.println("****************************************");
        System.out.println("\u001B[0m");

        Board board = new Board();

        System.out.println("\n\u001B[95m\u001B[1mGame Rules:\u001B[0m");
        System.out.println("1. Each player takes turns to make a move.");
        System.out.println("2. Enter your move in the format 'source-destination', e.g., 'e2-e4'.");
        System.out.println("3. Capture your opponent's pieces and protect your own.");
        System.out.println("4. Checkmate your opponent's king to win the game!");
        System.out.println("\n");

        //System.out.println("\n\u001B[1m\u001B[94mThanks for playing ChessMaster!\u001B[0m");

        board.displayBoard();

    }

}
