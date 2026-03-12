package week_5.problem_2;

public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isValid() {
        return row >= 1 && row <= 8 && col >= 1 && col <= 8;
    }

    @Override
    public String toString() {
        return "(" + row + "," + col + ")";
    }
}