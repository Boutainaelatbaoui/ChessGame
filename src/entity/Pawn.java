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
        int deltaX = Math.abs(endX - startX);
        int deltaY = endY - startY;

        if (destPiece != null && destPiece.isWhite() == this.isWhite()) {
            return false;
        }

        if (isWhite()) {
            if ((deltaY == 1 && deltaX == 0) || (deltaY == 2 && deltaX == 0 && startY == 1)) {
                return true;
            }else if(deltaY == 1 && deltaX == 1 && destPiece != null && !destPiece.isWhite()){
                return true;
            }
        }
        else {
            if ((deltaY == -1 && deltaX == 0) || (deltaY == -2 && deltaX == 0 && startY == 6)) {
                return true;
            }else if(deltaY == -1 && deltaX == 1 && destPiece != null && destPiece.isWhite()){
                return true;
            }
        }
        return false;
    }
}
