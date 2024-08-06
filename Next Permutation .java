Summary of this technique:
1.	From the right, towards left, find the point where the element decreases (I,e find the point of change).
2.	Find the immediate next greater number on right side part to the number at point of change.
3.	Swap the number at point of change and the immediate greater number.
4.	Reverse/Sort the array from point of change till end.
Code:
import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] A) {
        int poc = -1; // point of change
        // Step 1: Find the largest index poc such that A[poc] < A[poc + 1]
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] < A[i + 1]) {
                poc = i;
                break;
            }
        }

        if (poc == -1) {
            // If no such index exists, the array is in descending order
            // Reverse the entire array to get the smallest permutation
            reverse(A, 0, A.length - 1);
        } else {
            // Step 2: Find the largest index j such that A[poc] < A[j]
            int j = A.length - 1;
            while (A[j] <= A[poc]) {
                j--;
            }

            // Step 3: Swap elements at poc and j
            swap(A, poc, j);

            // Step 4: Reverse the sequence from poc + 1 to the end
            reverse(A, poc + 1, A.length - 1);
        }
    }

    private void reverse(int[] A, int start, int end) {
        while (start < end) {
            swap(A, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}


// TC: O(n)
// SC: O(1)

