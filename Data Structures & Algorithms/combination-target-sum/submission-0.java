class Solution {
    private void findSums(int[] nums, int index, List<List<Integer>> result, List<Integer> list, int target){
        if (target == 0){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if (target < 0 || index == nums.length){
            return;
        }

        list.add(nums[index]);
        target -= nums[index];
        findSums(nums, index, result, list, target);
        list.remove(list.size() - 1);
        target += nums[index];

        findSums(nums, index + 1, result, list, target);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        findSums(nums, 0, result, new ArrayList<Integer>(), target);
        return result;
    }
}
