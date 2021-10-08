// [1]
class Main {
    // Function to in-place merge two sorted arrays X[] and Y[]
    // invariant: `X[]` and `Y[]` are sorted at any point
    public static void merge(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;
 
        // Consider each element `X[i]` of array `X` and ignore the element if it is
        // already in the correct order; otherwise, swap it with the next smaller
        // element, which happens to be the first element of `Y`.
        for (int i = 0; i < m; i++) {
            // compare the current element of `X[]` with the first element of `Y[]`
            if (X[i] > Y[0]) {
                // swap `X[i] with `Y[0]`
                int temp = X[i];
                X[i] = Y[0];
                Y[0] = temp;
 
                int first = Y[0];
 
                // move `Y[0]` to its correct position to maintain the sorted
                // order of `Y[]`. Note: `Y[1…n-1]` is already sorted
                int k;
                for (k = 1; k < n && Y[k] < first; k++) {
                    Y[k - 1] = Y[k];
                }
                Y[k - 1] = first;
            }
        }
    }
}


// [2] sc -> 1, tc -> nlogn
public class MergeTwoSortedArrays {
 
    // Function to find next gap.
    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }
 
    private static void merge(int[] arr1, int[] arr2, int n, int m) {
        int i, j, gap = n + m;
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            // comparing elements in the first array.
            for (i = 0; i + gap < n; i++)
                if (arr1[i] > arr1[i + gap]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
 
            // comparing elements in both arrays.
            // if gap > n -> j = gap - n else j = 0
            for (j = gap > n ? gap - n : 0; i < n && j < m; i++, j++)
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
 
            if (j < m) {
                // comparing elements in the second array.
                for (j = 0; j + gap < m; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
                }
            }
        }
    }
}
