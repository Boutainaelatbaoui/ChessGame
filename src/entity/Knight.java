package entity;

public class Knight extends Piece {
    public Knight(boolean white) {
        super(white);
    }
    @Override
    public String getPieceSymbol() {
        return "N";
    }
    public boolean moveValid(int startX, int startY, int endX, int endY, Piece destPiece) {
        int diffX = Math.abs(endX - startX);
        int diffY = Math.abs(endY - startY);

        if (destPiece != null && destPiece.isWhite() == this.isWhite()) {
            return false;
        }

        if ((diffY == 2 && diffX == 1) || (diffX == 2 && diffY == 1)) {
            return true;
        }

        return false;
    }
}
