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
    public boolean moveValid(int startX, int startY, int endX, int endY, Piece destPiece) {
        int diffX = Math.abs(endX - startX);
        int diffY = endY - startY;

        if (destPiece != null && destPiece.isWhite() == this.isWhite()) {
            return false;
        }

        if (isWhite()) {
            if ((diffY == 1 && diffX == 0) || (diffY == 2 && diffX == 0 && startY == 1)) {
                return true;
            }else if(diffY == 1 && diffX == 1 && destPiece != null && !destPiece.isWhite()){
                return true;
            }
        }
        else {
            if ((diffY == -1 && diffX == 0) || (diffY == -2 && diffX == 0 && startY == 6)) {
                return true;
            }else if(diffY == -1 && diffX == 1 && destPiece != null && destPiece.isWhite()){
                return true;
            }
        }
        return false;
    }
}
