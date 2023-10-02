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
            // Check for obstructions
            int xStep = (diffX == 0) ? 0 : (endX > startX) ? 1 : -1;
            int yStep = (diffY == 0) ? 0 : (endY > startY) ? 1 : -1;

            int x = startX + xStep;
            int y = startY + yStep;

            while (x != endX || y != endY) {
                if (boxes[y][x].getPiece() != null) {
                    return false;
                }
                x += xStep;
                y += yStep;
            }
            return true;
        }

        return false;
    }

}
