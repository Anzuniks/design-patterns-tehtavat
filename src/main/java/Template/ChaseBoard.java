package Template;


/**
 * ChaseBoard is composed by ChaseGame. It knows the grid's size and how to
 * draw the runner (R) and chaser (C) on it — it knows nothing about turns,
 * players, or the Game framework itself.
 */


public class ChaseBoard {

    public final int size;

    public ChaseBoard(int size) {
        this.size = size;
    }

    public GridPosition clampedMove(GridPosition from, int deltaRow, int deltaCol) {
        int newRow  = Math.max(0, Math.min(size - 1, from.row) + deltaRow);
        int newCol  = Math.max(0, Math.min(size - 1, from.col) + deltaCol);
        return new GridPosition(newRow, newCol);
    }

    public void print(GridPosition runner, GridPosition chaser) {
        for (int row = 0; row < size; row++) {
            StringBuilder line = new StringBuilder();
            for (int col = 0; col < size; col++) {
                GridPosition here = new GridPosition(row, col);
                if (here.sameAs(runner) && here.sameAs(chaser)) {
                    line.append("X");
                } else if (here.sameAs(runner)) {
                    line.append("R");
                } else if (here.sameAs(chaser)) {
                    line.append("C");
                } else {
                    line.append(".");
                }
                line.append(' ');
            }
            System.out.println(line);
        }
    }
}
