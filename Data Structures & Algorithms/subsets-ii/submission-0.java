class Solution {
    private class IntTracker{
        private Integer num;
        public int count;

        public IntTracker(Integer num){
            this.num = num;
            this.count = 1;
        }

        public Integer getNum(){
            return this.num;
        }

        @Override
        public String toString(){
            return this.num.intValue() + " => " + this.count;
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(Collections.EMPTY_LIST);
        int prev = nums[0];
        int numNew = result.size();
        for (int num: nums){
            if (num != prev){
                numNew = result.size();
                prev = num;
            }
            int currSize = result.size();
            for (int i = currSize - numNew; i < currSize; ++i){
                List<Integer> newSubset = new ArrayList<Integer>(result.get(i));
                newSubset.add(Integer.valueOf(num));
                result.add(newSubset);
            }
        }
        return result;
    }
}
