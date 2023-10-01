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
            int stepX = (endX > startX) ? 1 : -1;
            int stepY = (endY > startY) ? 1 : -1;

            int x = startX + stepX;
            int y = startY + stepY;

            while (x != endX || y != endY){
                if (boxes[y][x].getPiece() != null) {
                    return false;
                }
                x += stepX;
                y += stepY;
            }
            return true;
        }

        return false;
    }
}
