package week_5.problem_2;

public class Main {
    public static void main(String[] args) {
        Piece rook = new Rook(new Position(1, 1));
        System.out.println("Rook (1,1) -> (1,8): " + rook.isLegalMove(new Position(1, 8))); // t
        System.out.println("Rook (1,1) -> (2,2): " + rook.isLegalMove(new Position(2, 2))); // f

        Piece knight = new Knight(new Position(4, 4));
        System.out.println("Knight (4,4) -> (6,5): " + knight.isLegalMove(new Position(6, 5))); // t
        System.out.println("Knight (4,4) -> (5,5): " + knight.isLegalMove(new Position(5, 5))); // f

        Piece king = new King(new Position(3, 3));
        System.out.println("King (3,3) -> (4,4): " + king.isLegalMove(new Position(4, 4))); // t
        System.out.println("King (3,3) -> (5,5): " + king.isLegalMove(new Position(5, 5))); // f

        Piece pawn = new Pawn(new Position(2, 2));
        System.out.println("Pawn (2,2) -> (3,2): " + pawn.isLegalMove(new Position(3, 2))); // t
        System.out.println("Pawn (2,2) -> (4,2): " + pawn.isLegalMove(new Position(4, 2))); // f
    }
}