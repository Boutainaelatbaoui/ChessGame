package entity;

public class Bishop extends Piece {
    public Bishop(boolean white) {
        super(white);
    }
    @Override
    public String getPieceSymbol() {
        return "B";
    }
    public boolean moveValid(int startX, int startY, int endX, int endY, Piece destPiece) {
        int deltaX = Math.abs(endX - startX);
        int deltaY = endY - startY;

        // White pawn moves forward (up the board)
        if (isWhite()) {
            if (deltaY == 1 && deltaX == 0) {
                // Pawn moves one square forward
                return true;
            } else if (deltaY == 2 && deltaX == 0 && startY == 1) {
                // Pawn's first move, moving two squares forward
                return true;
            } else if (deltaY == 1 && deltaX == 1) {
                // Pawn captures diagonally
                return true;
            }
        }
        // Black pawn moves forward (down the board)
        else {
            if (deltaY == -1 && deltaX == 0) {
                // Pawn moves one square forward
                return true;
            } else if (deltaY == -2 && deltaX == 0 && startY == 6) {
                // Pawn's first move, moving two squares forward
                return true;
            } else if (deltaY == -1 && deltaX == 1) {
                // Pawn captures diagonally
                return true;
            }
        }

        return false;
    }
}
