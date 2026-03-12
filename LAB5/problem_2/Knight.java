package week_5.problem_2;

public class Knight extends Piece {
    public Knight(Position a) {
        super(a);
    }

    @Override
    public boolean isLegalMove(Position b) {
        if (!basicChecks(b)) return false;
        int dr = Math.abs(a.getRow() - b.getRow());
        int dc = Math.abs(a.getCol() - b.getCol());
        return (dr == 2 && dc == 1) || (dr == 1 && dc == 2);
    }
}