class Solution {
    public void sortColors(int[] nums) {
        int low = 0;    // Pointer for the next position of 0
        int mid = 0;    // Pointer for the current element
        int high = nums.length - 1; // Pointer for the next position of 2
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1 is in the correct place, just move forward
                mid++;
            } else if (nums[mid] == 2){
                swap(nums, mid, high);
                high--;

            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

