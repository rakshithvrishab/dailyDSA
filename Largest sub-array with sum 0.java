Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Examples:

Input: arr[] = {15,-2,2,-8,1,7,10,23}, n = 8
Output: 5
Explanation: The largest subarray with sum 0 is -2 2 -8 1 7.
Input: arr[] = {2,10,4}, n = 3
Output: 0
Explanation: There is no subarray with 0 sum.
Input: arr[] = {1, 0, -4, 3, 1, 0}, n = 6
Output: 5
Explanation: The subarray is 0 -4 3 1 0.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1 <= n <= 105
-1000 <= arr[i] <= 1000, for each valid i

**********************************************************************************************************************************
Using hashmap 
**********************************************************************************************************************************
class GfG{
    int maxLen(int A[], int n){
        int sum = 0;
        int ans = 0;
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i=0;i<n;i++) {
            sum+=A[i];
            if(sum==0){
                ans = Math.max(ans , i-0+1);
            }
            if(!hs.containsKey(sum)) {
                hs.put(sum , i);
            }
            
            if(hs.containsKey(sum-0)) {
                ans = Math.max(ans , i-hs.get(sum));
            }
        }
        return ans;
    }
}


********************************************************************************************************************************
TC O(n)
SC O(n)

********************************************************************************************************************************