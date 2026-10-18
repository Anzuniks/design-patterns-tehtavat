# Algorithm Performance Comparison (Strategy pattern)

Three sorting algorithms implemented as interchangeable strategies and benchmarked
on a small (30) and a large (100,000) random integer array.

## Design

| Role (Strategy pattern) | Class |
|---|---|
| Strategy interface | `SortStrategy` |
| Concrete strategies | `InsertionSort`, `MergeSort`, `QuickSort` |
| Context | `Sorter` – holds a strategy, delegates `sort()`, measures time |
| Client | `Main` – generates data, swaps strategies, prints results |

Algorithm code is adapted from GeeksforGeeks; each class has a source reference comment.
No `java.util.Arrays.sort()` or other built-in sorting/copy helpers are used.

## Run

```bash
javac -d out src/sorting/*.java
java -cp out sorting.Main
```

## Example results (JDK 21)

| Algorithm | 30 elements | 100,000 elements |
|---|---|---|
| Insertion Sort | 0.002 ms | 670.5 ms |
| Merge Sort | 0.023 ms | 17.6 ms |
| Quick Sort | 0.032 ms | 7.6 ms |

Times vary between machines and runs.

## Observations

- **Small data:** Insertion Sort wins. With only 30 elements the O(n²) cost is tiny,
  while Merge Sort and Quick Sort pay for recursion (and Merge Sort for allocating
  temporary arrays). This is why real libraries switch to insertion sort for small subarrays.
- **Large data:** the asymptotic complexity dominates. Insertion Sort (O(n²)) is
  roughly 40–90× slower than the O(n log n) algorithms.
- **Quick vs Merge:** Quick Sort is about 2× faster on random data: it sorts in place,
  allocates nothing and has better cache locality. Merge Sort's advantage is its
  guaranteed O(n log n); Quick Sort with a last-element pivot degrades to O(n²) on
  already-sorted input.

## Measurement notes

- Each strategy sorts its own copy of the same data, so no algorithm gets pre-sorted input.
- Fixed random seed (42) makes runs repeatable.
- A few untimed warm-up runs happen first so JIT compilation doesn't distort the first timing.
- Correctness is verified after every sort.
