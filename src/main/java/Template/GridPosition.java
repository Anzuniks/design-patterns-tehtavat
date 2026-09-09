package Template;

/**
 * A simple immutable (row, col) coordinate on the chase grid.
 * Kept as its own small class so ChaseGame doesn't need to juggle
 * raw int pairs everywhere.
 */

public class GridPosition {

    public final int row;
    public final int col;

    public GridPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean sameAs(GridPosition other) {
        return row == other.row && col == other.col;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}
