package entity;

public class Rook extends Piece {
    public Rook(boolean white) {
        super(white);
    }
    @Override
    public String getPieceSymbol() {
        return "R";
    }
    public boolean moveValid(int startX, int startY, int endX, int endY, Piece destPiece, Box[][] boxes) {
        int xChange = Math.abs(endX - startX);
        int yChange = Math.abs(endY - startY);

        if (destPiece != null && destPiece.isWhite() == this.isWhite()) {
            return false;
        }

        if (xChange == 0 || yChange == 0) {
            // Check for obstructions
            int xStep = (xChange == 0) ? 0 : (endX > startX) ? 1 : -1;
            int yStep = (yChange == 0) ? 0 : (endY > startY) ? 1 : -1;

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
