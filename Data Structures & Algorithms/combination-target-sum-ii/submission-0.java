class Solution {
    private class CandidateTracker{
        private int candidate;
        public int count;

        public CandidateTracker(int candidate){
            this.candidate = candidate;
            this.count = 1;
        }

        public int getCandidate(){
            return this.candidate;
        }
    }

    private void findCombinations(List<CandidateTracker> candidateList, int index, List<List<Integer>> combinations, List<Integer> combination, int target){
        if (target == 0){
            combinations.add(new ArrayList<Integer>(combination));
            return;
        }
        if (target < 0 || index == candidateList.size()){
            return;
        }
        
        CandidateTracker curr = candidateList.get(index);
        if (curr.count > 0){
            curr.count--;
            combination.add(curr.getCandidate());
            findCombinations(candidateList, index, combinations, combination, target - curr.getCandidate());
            combination.remove(combination.size() - 1);
            curr.count++;
        }

        findCombinations(candidateList, index + 1, combinations, combination, target);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, CandidateTracker> candidatesMap = new HashMap<Integer, CandidateTracker>();

        for (int candidate: candidates){
            if (candidatesMap.containsKey(candidate)){
                candidatesMap.get(candidate).count++;
            }
            else{
                candidatesMap.put(candidate, new CandidateTracker(candidate));
            }
        }

        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        findCombinations(new ArrayList<CandidateTracker>(candidatesMap.values()), 0, combinations, new ArrayList<Integer>(), target);
        return combinations;
    }
}
