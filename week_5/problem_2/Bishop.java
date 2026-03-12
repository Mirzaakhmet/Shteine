package week_5.problem_2;

public class Bishop extends Piece {
    public Bishop(Position a) {
        super(a);
    }

    @Override
    public boolean isLegalMove(Position b) {
        if (!basicChecks(b)) return false;
        int dr = Math.abs(a.getRow() - b.getRow());
        int dc = Math.abs(a.getCol() - b.getCol());
        return dr == dc;
    }
}