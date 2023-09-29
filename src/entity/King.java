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
        int diffX = Math.abs(endX - startX);
        int diffY = Math.abs(endY - startY);

        if (destPiece != null && destPiece.isWhite() == this.isWhite()) {
            return false;
        }

        if (diffX <= 1 && diffY <= 1) {
            return true;
        }
        return false;
    }
}
