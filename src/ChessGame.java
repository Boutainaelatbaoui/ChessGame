import entity.Board;
import entity.Box;
import entity.Piece;
import entity.Player;
import enums.Color;
import enums.GameStatus;

import java.util.Arrays;
import java.util.Scanner;

public class ChessGame {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    private Box[][] boxes;
    private Scanner scanner = new Scanner(System.in);

    public ChessGame() {
        board = new Board();
    }

    private Player createPlayer(int playerNumber, Color playerColor) {
        System.out.print("Player " + playerNumber + ", please enter your name: ");
        String playerName = scanner.nextLine();
        return new Player(playerName, playerColor);
    }

    public void startGame() {
        System.out.println("\u001B[1m");
        System.out.println("****************************************");
        System.out.println("    \u001B[93m      CHESSMASTER - Welcome!      \u001B[0m   ");
        System.out.println("****************************************");
        System.out.println("\u001B[0m");

        System.out.println("\n\u001B[95m\u001B[1mGame Rules:\u001B[0m");
        System.out.println("1. Each player takes turns to make a move.");
        System.out.println("2. Enter your move in the format 'source-destination', e.g., 'e2-e4'.");
        System.out.println("3. Capture your opponent's pieces and protect your own.");
        System.out.println("4. Checkmate your opponent's king to win the game!");
        System.out.println("\n");

        player1 = createPlayer(1, (Math.random() < 0.5) ? Color.WHITE : Color.BLACK);
        player2 = createPlayer(2, (player1.getColor() == Color.WHITE) ? Color.BLACK : Color.WHITE);
        currentPlayer = player1.getColor() == Color.WHITE ? player1 : player2;

        System.out.println("Player 1: " + player1.getName() + " (Color: " + player1.getColor() + ")");
        System.out.println("Player 2: " + player2.getName() + " (Color: " + player2.getColor() + ") \n");

        board.displayBoard();

        playGame();
    }

    private void playGame() {
        while (!isGameOver()) {
            System.out.println(currentPlayer.getName() + "'s turn");

            // Get move input from the current player
            System.out.print("Enter your move (e.g., 'e2-e4'): ");
            String moveInput = scanner.nextLine();

            String[] moveParts = moveInput.split("-");

            if (moveParts.length != 2) {
                System.out.println("Invalid move format. Enter your move in the format 'source-destination'.");
                continue;
            }

            String sourceSquare = moveParts[0].trim();
            String destinationSquare = moveParts[1].trim();

            if (!isValidSquare(sourceSquare) || !isValidSquare(destinationSquare)) {
                System.out.println("Invalid square(s). Make sure squares are in the format 'a1' to 'h8'.");
                continue;
            }

            int startX = sourceSquare.charAt(0) - 'a';
            int startY = sourceSquare.charAt(1) - '1';
            int endX = destinationSquare.charAt(0) - 'a';
            int endY = destinationSquare.charAt(1) - '1';

            boolean moveSuccessful = board.applyMove(startX, startY, endX, endY, currentPlayer);

            if (moveSuccessful) {
                board.displayBoard();
                switchPlayer();
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean isValidSquare(String square) {
        return square.matches("[a-h][1-8]");
    }

    private boolean isGameOver() {
        if (board.getGameStatus() == GameStatus.WHITEWIN || board.getGameStatus() == GameStatus.BLACKWIN) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.startGame();
    }
}
