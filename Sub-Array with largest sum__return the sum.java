class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize the variables
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update currentSum to the maximum of the current element alone
            // or the current element added to the previous currentSum
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update maxSum to the maximum of maxSum and currentSum
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
