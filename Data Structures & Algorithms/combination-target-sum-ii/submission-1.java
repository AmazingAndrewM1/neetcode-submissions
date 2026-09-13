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

    private void findCombinations(CandidateTracker[] candidateArray, int index, List<List<Integer>> combinations, List<Integer> combination, int target){
        if (target == 0){
            combinations.add(new ArrayList<Integer>(combination));
            return;
        }
        if (index == candidateArray.length){
            return;
        }
        
        CandidateTracker curr = candidateArray[index];
        int newTarget = target - curr.getCandidate();
        if (curr.count > 0 && newTarget >= 0){
            curr.count--;
            combination.add(curr.getCandidate());
            findCombinations(candidateArray, index, combinations, combination, newTarget);
            combination.remove(combination.size() - 1);
            curr.count++;
        }

        if (newTarget >= 0){
            findCombinations(candidateArray, index + 1, combinations, combination, target);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, CandidateTracker> candidateMap = new HashMap<Integer, CandidateTracker>();

        for (int candidate: candidates){
            if (candidateMap.containsKey(candidate)){
                candidateMap.get(candidate).count++;
            }
            else{
                candidateMap.put(candidate, new CandidateTracker(candidate));
            }
        }

        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        CandidateTracker[] candidateArray = candidateMap.values().toArray(new CandidateTracker[0]);
        Arrays.sort(candidateArray, (CandidateTracker a, CandidateTracker b) -> 
            Integer.compare(a.getCandidate(), b.getCandidate())
        );
        findCombinations(candidateArray, 
                         0, 
                         combinations, 
                         new ArrayList<Integer>(), 
                         target);
        return combinations;
    }
}
