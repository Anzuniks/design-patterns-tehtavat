package Strategy;

/**
 * Concrete strategy: Insertion Sort.
 *
 * Source: adapted from GeeksforGeeks, "Insertion Sort Algorithm"
 * https://www.geeksforgeeks.org/insertion-sort-algorithm/
 * Changes: wrapped in a class implementing SortStrategy; removed the
 * static main/printArray helpers.
 *
 * How it works: the array is split into a sorted left part and an
 * unsorted right part. Each element ("key") is taken from the unsorted
 * part and shifted left past every larger element until it reaches its
 * correct spot, like sorting playing cards in your hand.
 *
 * Time: O(n^2) average/worst, O(n) best (already sorted). Space: O(1).
 * Very fast on small or nearly sorted inputs because of tiny overhead.
 */
public class InsertionSort implements SortStrategy {

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements of the sorted part that are greater than key
            // one position to the right to make room for key.
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }
}
