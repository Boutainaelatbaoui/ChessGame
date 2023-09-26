package entity;

public class King extends Piece {
    public King(boolean white) {
        super(white);
    }
    @Override
    public String getPieceSymbol() {
        return "K";
    }
    public boolean moveValid(int startX, int startY, int endX, int endY, Piece destPiece) {
        int xChange = Math.abs(endX - startX);
        int yChange = endY - startY;

        if (isWhite()) {
            if (yChange == 1 && xChange == 0) {
                // Pawn moves one square forward
                return true;
            } else if (yChange == 2 && xChange == 0 && startY == 1) {
                // Pawn's first move, moving two squares forward
                return true;
            } else if (yChange == 1 && xChange == 1) {
                // Pawn captures diagonally
                return true;
            }
        }
        else {
            if (yChange == -1 && xChange == 0) {
                // Pawn moves one square forward
                return true;
            } else if (yChange == -2 && xChange == 0 && startY == 6) {
                // Pawn's first move, moving two squares forward
                return true;
            } else if (yChange == -1 && xChange == 1) {
                // Pawn captures diagonally
                return true;
            }
        }

        return false;
    }
}
