package Strategy;

/**
 * Concrete strategy: Merge Sort.
 *
 * Source: adapted from GeeksforGeeks, "Merge Sort - Data Structure and
 * Algorithms Tutorials" https://www.geeksforgeeks.org/merge-sort/
 * Changes: wrapped in a class implementing SortStrategy; the public
 * sort(int[]) method calls the recursive helper with the full range;
 * helpers made private; removed main/printArray.
 *
 * How it works (divide and conquer):
 *   1. Divide the array into two halves.
 *   2. Recursively sort each half.
 *   3. Merge the two sorted halves into one sorted range.
 *
 * Time: O(n log n) in every case. Space: O(n) for the temporary arrays.
 * Stable (equal elements keep their original order).
 */
public class MergeSort implements SortStrategy {

    @Override
    public void sort(int[] arr) {
        if (arr.length > 1) {
            mergeSort(arr, 0, arr.length - 1);
        }
    }

    /** Recursively sorts arr[left..right]. */
    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // avoids int overflow

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /** Merges the sorted subarrays arr[left..mid] and arr[mid+1..right]. */
    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Copy both halves into temporary arrays
        int[] leftPart = new int[n1];
        int[] rightPart = new int[n2];
        for (int i = 0; i < n1; i++) {
            leftPart[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightPart[j] = arr[mid + 1 + j];
        }

        // Repeatedly take the smaller front element of the two halves
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftPart[i] <= rightPart[j]) {
                arr[k++] = leftPart[i++];
            } else {
                arr[k++] = rightPart[j++];
            }
        }

        // Copy whatever is left over (only one of these loops runs)
        while (i < n1) {
            arr[k++] = leftPart[i++];
        }
        while (j < n2) {
            arr[k++] = rightPart[j++];
        }
    }

    @Override
    public String getName() {
        return "Merge Sort";
    }
}
