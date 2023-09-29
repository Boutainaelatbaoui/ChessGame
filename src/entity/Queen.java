package entity;

public class Queen extends Piece {
    public Queen(boolean white) {
        super(white);
    }
    @Override
    public String getPieceSymbol() {
        return "Q";
    }
    public boolean moveValid(int startX, int startY, int endX, int endY, Piece destPiece) {
        int diffX = Math.abs(endX - startX);
        int diffY = Math.abs(endY - startY);

        if (destPiece != null && destPiece.isWhite() == this.isWhite()) {
            return false;
        }

        if ((diffX == 0 && diffY > 0) || (diffY == 0 && diffX > 0) || (diffX == diffY && diffX > 0)) {
            return true;
        }

        return false;
    }

}
