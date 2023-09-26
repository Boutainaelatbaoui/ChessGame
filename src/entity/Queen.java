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
        int xChange = Math.abs(endX - startX);
        int yChange = Math.abs(endY - startY);

        if (destPiece != null && destPiece.isWhite() == this.isWhite()) {
            return false;
        }

        if (xChange == 0 && yChange > 0) {
            return true;
        } else if (yChange == 0 && xChange > 0) {
            return true;
        } else if (xChange == yChange && xChange > 0) {
            return true;
        }

        return false;
    }

}
