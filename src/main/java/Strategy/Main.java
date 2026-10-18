package Strategy;

import java.util.Random;

/**
 * Client of the Strategy pattern: creates the data sets, runs every
 * strategy through the same Sorter context, and prints the timings.
 */
public class Main {

    private static final int SMALL_SIZE = 30;
    private static final int LARGE_SIZE = 100_000;
    private static final int MAX_VALUE = 1_000_000;

    /** Fixed seed so every run uses the same data and results are repeatable. */
    private static final long SEED = 42L;

    /** Untimed runs before measuring, so the JIT compiler has warmed up. */
    private static final int WARMUP_ROUNDS = 5;

    public static void main(String[] args) {
        Random random = new Random(SEED);
        int[] smallData = generateRandomArray(SMALL_SIZE, random);
        int[] largeData = generateRandomArray(LARGE_SIZE, random);

        SortStrategy[] strategies = {
                new InsertionSort(),
                new MergeSort(),
                new QuickSort()
        };

        Sorter sorter = new Sorter(strategies[0]);

        warmUp(sorter, strategies, random);

        runBenchmark("Small data set", smallData, sorter, strategies);
        runBenchmark("Large data set", largeData, sorter, strategies);
    }

    /** Fills an array with random integers in [0, MAX_VALUE). */
    private static int[] generateRandomArray(int size, Random random) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(MAX_VALUE);
        }
        return arr;
    }

    /**
     * Runs each strategy a few times on separate throw-away data so the
     * first measured run is not slowed down by class loading / JIT.
     */
    private static void warmUp(Sorter sorter, SortStrategy[] strategies, Random random) {
        for (SortStrategy strategy : strategies) {
            sorter.setStrategy(strategy);
            for (int round = 0; round < WARMUP_ROUNDS; round++) {
                sorter.sort(generateRandomArray(5_000, random));
            }
        }
    }

    /**
     * Sorts a fresh copy of the same data with every strategy and prints
     * the elapsed time. Each strategy gets its own copy, otherwise the
     * second algorithm would receive an already sorted array.
     */
    private static void runBenchmark(String label, int[] data, Sorter sorter, SortStrategy[] strategies) {
        System.out.println();
        System.out.printf("=== %s (%,d elements) ===%n", label, data.length);

        for (SortStrategy strategy : strategies) {
            int[] copy = copyArray(data);
            sorter.setStrategy(strategy);

            long nanos = sorter.sortAndMeasure(copy);

            System.out.printf("%-16s %14.3f ms   sorted correctly: %s%n",
                    strategy.getName(), nanos / 1_000_000.0, isSorted(copy) ? "yes" : "NO");
        }

        if (data.length <= 50) {
            int[] copy = copyArray(data);
            sorter.sort(copy);
            System.out.println("Original: " + arrayToString(data));
            System.out.println("Sorted:   " + arrayToString(copy));
        }
    }

    /** Manual copy (keeps the program free of java.util.Arrays). */
    private static int[] copyArray(int[] source) {
        int[] copy = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            copy[i] = source[i];
        }
        return copy;
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(arr[i]);
        }
        return sb.append("]").toString();
    }
}
