class Solution {
    private int getNextDifferent(int[] nums, int index){
        while (index < nums.length - 1 && nums[index] == nums[index + 1]){
            index++;
        }
        return index + 1;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int i = 0;
        while (i < nums.length - 2){
            int temp = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = temp + nums[left] + nums[right];
                if (sum == 0){
                    result.add(Arrays.asList(temp, nums[left], nums[right]));
                    left = getNextDifferent(nums, left);
                    right--;
                }
                else if (sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
            i = getNextDifferent(nums, i);
        }
        return result;
    }
}
