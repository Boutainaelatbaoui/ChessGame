package entity;

public class Bishop extends Piece {
    public Bishop(boolean white) {
        super(white);
    }
    @Override
    public String getPieceSymbol() {
        return "B";
    }
    public boolean moveValid(int startX, int startY, int endX, int endY, Piece destPiece, Box[][] boxes) {
        int diffX = Math.abs(endX - startX);
        int diffY = Math.abs(endY - startY);

        if (destPiece != null && destPiece.isWhite() == this.isWhite()) {
            return false;
        }

        if ((diffX == diffY)) {
            return true;
        }

        return false;
    }
}
