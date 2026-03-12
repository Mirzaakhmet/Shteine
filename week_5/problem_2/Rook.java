package week_5.problem_2;

public class Rook extends Piece {
    public Rook(Position a) {
        super(a);
    }

    @Override
    public boolean isLegalMove(Position b) {
        if (!basicChecks(b)) return false;
        return a.getRow() == b.getRow() || a.getCol() == b.getCol();
    }
}