
Subarray with given XOR
Given an array of integers A and an integer B.
Find the total number of subarrays having bitwise XOR of all elements equals to B.

Problem Constraints
1 <= length of the array <= 105
1 <= A[i], B <= 109

*************************************************************************************
import java.util.HashMap;

public class Solution {
    public int solve(int[] A, int B) {
        int xr = 0;
        int count = 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        
        // Initialize the hash map with prefix XOR 0 having count 1.
        hs.put(0, 1);

        for (int i = 0; i < A.length; i++) {
            // Compute the prefix XOR up to index i
            xr ^= A[i];

            // Check if there's a prefix XOR that results in the desired XOR B
            if (hs.containsKey(xr ^ B)) {
                count += hs.get(xr ^ B);
            }

            // Update the hash map with the current prefix XOR
            hs.put(xr, hs.getOrDefault(xr, 0) + 1);
        }

        return count;
    }
}

***************************************************************************************
TC: O(n)
SC: O(n)
***************************************************************************************