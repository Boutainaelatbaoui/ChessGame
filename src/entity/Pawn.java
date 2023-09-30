package entity;

public class Pawn extends Piece {
    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public String getPieceSymbol() {
        return "P";
    }

    @Override
    public boolean moveValid(int startX, int startY, int endX, int endY, Piece destPiece, Box[][] boxes) {
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);

        if (destPiece != null && destPiece.isWhite() == this.isWhite()) {
            return false;
        }

        if (isWhite()) {
            if (deltaY == 1 && deltaX == 0) {
                if (destPiece == null) {
                    return true;
                }
            } else if (deltaY == 2 && deltaX == 0 && startY == 1) {
                if (destPiece == null && boxes[startY + 1][startX].getPiece() == null) {
                    return true;
                }
            } else if (deltaY == 1 && deltaX == 1 && destPiece != null && !destPiece.isWhite()) {
                return true;
            }
        } else {
            if (deltaY == 1 && deltaX == 0) {
                if (destPiece == null) {
                    return true;
                }
            } else if (deltaY == 2 && deltaX == 0 && startY == 6) {
                if (destPiece == null && boxes[startY - 1][startX].getPiece() == null) {
                    return true;
                }
            } else if (deltaY == 1 && deltaX == 1 && destPiece != null && destPiece.isWhite()) {
                return true;
            }
        }

        return false;
    }
}
