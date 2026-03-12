package week_5.problem_2;

public abstract class Piece {
    protected Position a;

    public Piece(Position a) {
        this.a = a;
    }

    public Position getPosition() {
        return a;
    }

    public void setPosition(Position a) {
        this.a = a;
    }

    protected boolean basicChecks(Position b) {
        if (b == null) return false;
        if (!a.isValid() || !b.isValid()) return false;
        if (a.getRow() == b.getRow() && a.getCol() == b.getCol()) return false;
        return true;
    }

    public abstract boolean isLegalMove(Position b);
}