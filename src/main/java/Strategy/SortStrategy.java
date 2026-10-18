package Strategy;

/**
 * Strategy interface: every sorting algorithm implements this.
 * The context (Sorter) only knows about this interface, never about
 * concrete algorithms, so strategies can be swapped at runtime.
 */
public interface SortStrategy {

    /** Sorts the given array in place, in ascending order. */
    void sort(int[] arr);

    /** Human-readable name used in the output. */
    String getName();
}
