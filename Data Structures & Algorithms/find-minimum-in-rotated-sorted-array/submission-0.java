class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int mid = (left + right) / 2;
            if (nums[left] < nums[right]){
                // Subarray already sorted
                right = left;
            }
            else if (nums[left] <= nums[mid]){
                // Subarray left section sorted
                left = mid + 1;
            }
            else{
                // Subarray right section sorted
                right = mid;
            }
        }
        return nums[left];
    }
}
