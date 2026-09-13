class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Deque<List<Integer>> permutations = new ArrayDeque<List<Integer>>();
        permutations.addLast(Collections.EMPTY_LIST);    
        for (int num: nums){
            int currSize = permutations.size();
            for (int i = 0; i < currSize; ++i){
                List<Integer> permutation = permutations.removeFirst();
                for (int j = 0; j <= permutation.size(); ++j){
                    List<Integer> newPermutation = new ArrayList<Integer>(permutation.subList(0, j));
                    newPermutation.add(Integer.valueOf(num));
                    newPermutation.addAll(permutation.subList(j, permutation.size()));
                    permutations.addLast(newPermutation);
                }
            }
        }
        return new ArrayList<List<Integer>>(permutations);
    }
}
