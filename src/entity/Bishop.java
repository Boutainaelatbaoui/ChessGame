package entity;

public class Bishop extends Piece {
    public Bishop(boolean white) {
        super(white);
    }
    @Override
    public String getPieceSymbol() {
        return "♝";
    }
}
