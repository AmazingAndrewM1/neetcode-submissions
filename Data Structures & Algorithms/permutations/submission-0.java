class Solution {
    public List<List<Integer>> permute(int[] nums) {    
        List<List<Integer>> permutations = new ArrayList<List<Integer>>(Arrays.asList(new ArrayList<Integer>()));
        for (int num: nums){
            List<List<Integer>> newPermutations = new ArrayList<List<Integer>>();    
            for (List<Integer> permutation: permutations){
                for (int i = 0; i <= permutation.size(); ++i){
                    List<Integer> newPermutation = new ArrayList<Integer>(permutation.subList(0, i));
                    newPermutation.add(Integer.valueOf(num));
                    newPermutation.addAll(permutation.subList(i, permutation.size()));
                    newPermutations.add(newPermutation);
                }
            }
            permutations = newPermutations;
        }
        return permutations;
    }
}
