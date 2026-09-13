class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left + 1 < right){
            int mid = (left + right) / 2;
            boolean isLeftSorted = nums[left] <= nums[mid];
            boolean isRightSorted = nums[mid] <= nums[right];

            if (isLeftSorted && nums[left] <= target && target <= nums[mid]){
                right = mid;
            }
            else if (isLeftSorted){
                left = mid;
            }
            else if (isRightSorted && nums[mid] <= target && target <= nums[right]){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        if (nums[left] == target){
            result = left;
        }
        else if (nums[right] == target){
            result = right;
        }
        return result;
    }
}
