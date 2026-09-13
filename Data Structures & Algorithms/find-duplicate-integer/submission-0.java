class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] hasSeen = new boolean[nums.length];
        for (int num: nums){
            if (hasSeen[num]){
                return num;
            }
            hasSeen[num] = true;
        }
        return 0;
    }
}
