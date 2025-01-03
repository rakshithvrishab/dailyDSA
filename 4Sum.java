import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] A, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = A.length;

        // Sort the array to handle duplicates and use two-pointer technique
        Arrays.sort(A);

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate values for the first position
            if (i > 0 && A[i] == A[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate values for the second position
                if (j > i + 1 && A[j] == A[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long)A[i] + A[j] + A[k] + A[l];
                    
                    if (sum == target) {
                        ans.add(Arrays.asList(A[i], A[j], A[k], A[l]));

                        // Skip duplicate values for the third and fourth positions
                        while (k < l && A[k] == A[k + 1]) k++;
                        while (k < l && A[l] == A[l - 1]) l--;

                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return ans;
    }
}


Time Complexity (TC): O(n^3)
Space Complexity (SC) : O(1) for auxiliary space (excluding output), or 
𝑂(𝑘)where k is the number of quadruplets found.
