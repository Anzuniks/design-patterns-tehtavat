package Strategy;

/**
 * Context class of the Strategy pattern.
 *
 * Holds a reference to a SortStrategy and delegates the actual sorting to
 * it. The client can change the strategy at any time with setStrategy(),
 * and Sorter itself never needs to change when new algorithms are added.
 */
public class Sorter {

    private SortStrategy strategy;

    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public SortStrategy getStrategy() {
        return strategy;
    }

    /** Sorts the array in place using the current strategy. */
    public void sort(int[] arr) {
        strategy.sort(arr);
    }

    /**
     * Sorts the array with the current strategy and returns the elapsed
     * time in nanoseconds.
     */
    public long sortAndMeasure(int[] arr) {
        long start = System.nanoTime();
        strategy.sort(arr);
        return System.nanoTime() - start;
    }
}
