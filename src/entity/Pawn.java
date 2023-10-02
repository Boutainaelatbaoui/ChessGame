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
        int diffX = Math.abs(endX - startX);
        int diffY = endY - startY;

        if (destPiece != null && destPiece.isWhite() == this.isWhite()) {
            return false;
        }

        if (isWhite()) {
            if (diffY == 1 && diffX == 0) {
                if (destPiece == null) {
                    return true;
                }
            } else if (diffY == 2 && diffX == 0 && startY == 1) {
                if (destPiece == null && boxes[startY + 1][startX].getPiece() == null) {
                    return true;
                }
            } else if (diffY == 1 && diffX == 1 && destPiece != null && !destPiece.isWhite()) {
                return true;
            }
        } else {
            if (diffY == -1 && diffX == 0) {
                if (destPiece == null) {
                    return true;
                }
            } else if (diffY == -2 && diffX == 0 && startY == 6) {
                if (destPiece == null && boxes[startY - 1][startX].getPiece() == null) {
                    return true;
                }
            } else if (diffY == -1 && diffX == 1 && destPiece != null && destPiece.isWhite()) {
                return true;
            }
        }

        return false;
    }
}
