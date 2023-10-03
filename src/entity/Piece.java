package entity;

public abstract class Piece {
    private boolean killed = false;
    private boolean white = false;
    public boolean isFirstMove = true;

    public Piece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public boolean isKilled() {
        return killed;
    }

    public abstract String getPieceSymbol();

    public void setFirstMove(boolean firstMove) {
        isFirstMove = !firstMove;
    }

    public boolean isFirstMove() {
        return isFirstMove;
    }
    public abstract boolean moveValid(int startX, int startY, int endX, int endY, Piece destPiece, Box[][] boxes);

}

