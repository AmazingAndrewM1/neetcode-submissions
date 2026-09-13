class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; ++i){
            int num = nums[i];

            if (indexMap.containsKey(target - num)){
                return new int[]{indexMap.get(target - num), i};
            }

            indexMap.put(num, i);
        }

        return new int[]{-1, -1};
    }
}
