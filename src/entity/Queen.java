package entity;

public class Queen extends Piece {
    public Queen(boolean white) {
        super(white);
    }
    @Override
    public String getPieceSymbol() {
        return "Q";
    }
    public boolean moveValid(int startX, int startY, int endX, int endY, Piece destPiece, Box[][] boxes) {
        int diffX = Math.abs(endX - startX);
        int diffY = Math.abs(endY - startY);

        if (destPiece != null && destPiece.isWhite() == this.isWhite()) {
            return false;
        }

        if ((diffX == 0 && diffY > 0) || (diffY == 0 && diffX > 0) || (diffX == diffY)) {
            return true;
        }

        return false;
    }

}
