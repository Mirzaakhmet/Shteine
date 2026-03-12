package week_5.problem_2;

public class Pawn extends Piece {

    private boolean firstMove = true;

    public Pawn(Position a) {
        super(a);
    }

    @Override
    public boolean isLegalMove(Position b) {
        if (!basicChecks(b)) return false;

        int dr = b.getRow() - a.getRow();
        int dc = b.getCol() - a.getCol();

        if (dr == 1 && dc == 0) {
            firstMove = false;
            return true;
        }

        if (firstMove && dr == 2 && dc == 0) {
            firstMove = false;
            return true;
        }

        return false;
    }
}
