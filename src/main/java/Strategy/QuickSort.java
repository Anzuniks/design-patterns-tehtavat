package Strategy;

/**
 * Concrete strategy: Quick Sort (Lomuto partition, last element as pivot).
 *
 * Source: adapted from GeeksforGeeks, "Quick Sort"
 * https://www.geeksforgeeks.org/quick-sort-algorithm/
 * Changes: wrapped in a class implementing SortStrategy; the public
 * sort(int[]) method calls the recursive helper with the full range;
 * helpers made private; removed main/printArray.
 *
 * How it works (divide and conquer):
 *   1. Pick a pivot (here: the last element of the range).
 *   2. Partition: move every element smaller than the pivot to its left,
 *      then put the pivot right after them. The pivot is now in its
 *      final sorted position.
 *   3. Recursively sort the part left of the pivot and the part right of it.
 *
 * Time: O(n log n) average, O(n^2) worst case (e.g. already sorted input
 * with this pivot choice). Space: O(log n) recursion stack on average.
 * In practice usually the fastest of the three on random data, because it
 * sorts in place and has good cache behaviour.
 */
public class QuickSort implements SortStrategy {

    @Override
    public void sort(int[] arr) {
        if (arr.length > 1) {
            quickSort(arr, 0, arr.length - 1);
        }
    }

    /** Recursively sorts arr[low..high]. */
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Lomuto partition: places the pivot (arr[high]) at its correct
     * position and returns that index.
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // end of the "smaller than pivot" region

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }
}
