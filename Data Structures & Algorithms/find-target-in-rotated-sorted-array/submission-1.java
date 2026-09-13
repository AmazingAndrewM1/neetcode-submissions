class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int mid = (left + right) / 2;
            boolean isLeftSorted = nums[left] <= nums[mid];

            if (isLeftSorted && nums[left] <= target && target <= nums[mid]){
                right = mid;
            }
            else if (isLeftSorted){
                left = mid + 1;
            }
            else if (nums[mid] <= target && target <= nums[right]){
                left = mid;
            }
            else{
                right = mid - 1;
            }
        }

        int result = -1;
        if (nums[left] == target){
            result = left;
        }
        return result;
    }
}
