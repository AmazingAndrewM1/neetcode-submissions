class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int num: nums){
            set.add(num);
        }

        int longest = 0;
        for (int num: set){
            int length = 1;
            int tempNum = num + 1;
            while (set.contains(tempNum)){
                length++;
                tempNum++;
            }
            if (length > longest){
                longest = length;
            }
        }

        return longest;
    }
}
