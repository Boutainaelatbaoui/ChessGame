package entity;

public class Knight extends Piece {
    public Knight(boolean white) {
        super(white);
    }
    @Override
    public String getPieceSymbol() {
        return "N";
    }
}
