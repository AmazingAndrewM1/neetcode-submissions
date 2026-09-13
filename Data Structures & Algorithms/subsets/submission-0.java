class Solution {
    private void subsetsHelper(int[] nums, int index, List<Integer> subset, List<List<Integer>> subsets){
        if (index == nums.length){
            subsets.add(new ArrayList<Integer>(subset));
            return;
        }
        
        subsetsHelper(nums, index + 1, subset, subsets);
        
        subset.add(nums[index]);
        subsetsHelper(nums, index + 1, subset, subsets);
        subset.remove(subset.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        subsetsHelper(nums, 0, new ArrayList<Integer>(nums.length), subsets);
        return subsets;
    }
}
