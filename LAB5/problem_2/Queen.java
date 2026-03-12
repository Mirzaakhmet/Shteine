package week_5.problem_2;
public class Queen extends Piece {
    public Queen(Position a) {
        super(a);
    }

    @Override
    public boolean isLegalMove(Position b) {
        if (!basicChecks(b)) return false;

        int dr = Math.abs(a.getRow() - b.getRow());
        int dc = Math.abs(a.getCol() - b.getCol());

        boolean rookMove = a.getRow() == b.getRow() || a.getCol() == b.getCol();
        boolean bishopMove = dr == dc;

        return rookMove || bishopMove;
    }
}