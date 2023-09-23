package entity;

public class Board {
    private Box[][] boxes;

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        boxes = new Box[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[i][j] = new Box(i, j, null);
            }
        }

        setUpBlackPieces();
        setUpWhitePieces();
    }

    private void setUpBlackPieces() {
        boxes[7][0] = new Box(7, 0, new Rook(false));
        boxes[7][1] = new Box(7, 1, new Knight(false));
        boxes[7][2] = new Box(7, 2, new Bishop(false));
        boxes[7][3] = new Box(7, 3, new Queen(false));
        boxes[7][4] = new Box(7, 4, new King(false));
        boxes[7][5] = new Box(7, 5, new Bishop(false));
        boxes[7][6] = new Box(7, 6, new Knight(false));
        boxes[7][7] = new Box(7, 7, new Rook(false));

        for (int i = 0; i < 8; i++) {
            boxes[6][i] = new Box(6, i, new Pawn(false));
        }
    }

    private void setUpWhitePieces() {
        boxes[0][0] = new Box(0, 0, new Rook(true));
        boxes[0][1] = new Box(0, 1, new Knight(true));
        boxes[0][2] = new Box(0, 2, new Bishop(true));
        boxes[0][3] = new Box(0, 3, new Queen(true));
        boxes[0][4] = new Box(0, 4, new King(true));
        boxes[0][5] = new Box(0, 5, new Bishop(true));
        boxes[0][6] = new Box(0, 6, new Knight(true));
        boxes[0][7] = new Box(0, 7, new Rook(true));

        for (int i = 0; i < 8; i++) {
            boxes[1][i] = new Box(6, i, new Pawn(true));
        }
    }

    public void displayBoard() {
        for (int row = 7; row >= 0; row--) {
            System.out.print(row + 1 + " ");
            for (int col = 0; col < 8; col++) {
                Box box = boxes[row][col];
                Piece piece = box.getPiece();
                String color = (row + col) % 2 == 0 ? "47" : "100"; //color of background
                if (piece == null) {
                    System.out.print("\u001B[" + color + "m   \u001B[0m");
                } else {
                    String symbol = String.valueOf(piece.getPieceSymbol());
                    String pieceColor = piece.isWhite() ? "97" : "30"; // color of piece
                    System.out.print("\u001B[" + color + ";"+ pieceColor + "m " + symbol + " \u001B[0m");
                }
            }
            System.out.println();
        }
        System.out.println("  a  b  c  d  e  f  g  h");

    }


}
