package entity;

public class King extends Piece {
    public King(boolean white) {
        super(white);
    }
    @Override
    public String getPieceSymbol() {
        return "K";
    }
    public boolean moveValid(int startX, int startY, int endX, int endY) {
        int deltaX = Math.abs(endX - startX);
        int deltaY = endY - startY;

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
