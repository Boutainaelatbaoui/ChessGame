package entity;

import enums.Color;
import enums.GameStatus;

public class Board {
    private Box[][] boxes;
    private GameStatus gameStatus;

    public Board() {
        initializeBoard();
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Box getBox(int x, int y) {
        return boxes[y][x];
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
    public boolean applyMove(int startX, int startY, int endX, int endY, Player currentPlayer) {
        Box startBox = boxes[startY][startX];
        Box endBox = boxes[endY][endX];

        Piece sourcePiece = startBox.getPiece();
        Piece destPiece = endBox.getPiece();

        if (sourcePiece != null) {
            boolean isWhitePiece = sourcePiece.isWhite();
            boolean isCorrectColor = (isWhitePiece && currentPlayer.getColor() == Color.WHITE) ||
                    (!isWhitePiece && currentPlayer.getColor() == Color.BLACK);

            if (isCorrectColor) {
                if (performCastling(startX, startY, endX, endY)){
                    return true;
                } else if (sourcePiece.moveValid(startX, startY, endX, endY, destPiece, boxes)) {
                    // Capture the opponent's piece
                    if (destPiece != null) {
                        destPiece.setKilled(true);
                        if (destPiece instanceof King && destPiece.isWhite()) {
                            setGameStatus(GameStatus.BLACKWIN);
                            System.out.println("The Black wins");
                        }else if (destPiece instanceof King && !destPiece.isWhite()){
                            setGameStatus(GameStatus.WHITEWIN);
                            System.out.println("The White wins");
                        }
                    }
                    endBox.setPiece(sourcePiece);
                    startBox.setPiece(null);
                    return true;
                } else {
                    System.out.println("Invalid move for this piece.");
                }
            } else {
                System.out.println("Invalid move. Make sure you are moving your own piece.");
            }
        } else {
            System.out.println("Invalid move. There is no piece at the source square.");
        }
        return false;
    }
    private boolean arePiecesBetween(int startX, int endX, int startY) {
        int xStep = (endX > startX) ? 1 : (endX < startX) ? -1 : 0;

        int x = startX + xStep;

        while (x != endX)  {
            if (boxes[startY][x].getPiece() != null) {
                return true;
            }
            x += xStep;
        }

        return false;
    }

    public boolean performCastling(int kingX, int kingY, int endX, int endY) {
        Piece kingPiece = boxes[kingY][kingX].getPiece();

        if (kingPiece instanceof King) {
            int rookX = endX;
            int rookY = endY;

            Piece rookPiece = boxes[rookY][rookX].getPiece();

            if (kingPiece.isFirstMove() && rookPiece instanceof Rook && rookPiece.isFirstMove()) {
                if (!arePiecesBetween(kingX, rookX, kingY)) {
                    if (rookX == 0) {
                        boxes[kingY][kingX].setPiece(null);
                        boxes[kingY][rookX].setPiece(null);
                        boxes[kingY][kingX - 2].setPiece(kingPiece);
                        boxes[kingY][kingX - 1].setPiece(rookPiece);
                    } else {
                        boxes[kingY][kingX].setPiece(null);
                        boxes[kingY][rookX].setPiece(null);
                        boxes[kingY][kingX + 2].setPiece(kingPiece);
                        boxes[kingY][kingX + 1].setPiece(rookPiece);
                    }

                    kingPiece.setFirstMove(false);
                    rookPiece.setFirstMove(false);

                    return true;
                }
            }
        }

        return false;
    }

    private boolean isKingInCheck(boolean isWhite, Box[][] boxes) {
        int kingX = -1;
        int kingY = -1;

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Piece piece = boxes[y][x].getPiece();
                if (piece instanceof King && piece.isWhite() == isWhite) {
                    kingX = x;
                    kingY = y;
                    break;
                }
            }
        }

        if (kingX == -1 || kingY == -1) {
            return false;
        }

        // Check if the king is under threat
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Piece piece = boxes[y][x].getPiece();
                if (piece != null && piece.isWhite() != isWhite) {
                    if (piece.moveValid(x, y, kingX, kingY, null, boxes)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
