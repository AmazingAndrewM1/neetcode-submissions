class Solution {
    private void getPartitionsHelper(String s, int i, boolean[][] isPalindrome, List<List<String>> result, List<String> partition){
        if (i >= s.length()){
            result.add(new ArrayList<String>(partition));
            return;
        }

        for (int j = i; j < s.length(); ++j){
            if (isPalindrome[i][j]){
                partition.addLast(s.substring(i, j + 1));
                getPartitionsHelper(s, j + 1, isPalindrome, result, partition);
                partition.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int startCol = 0; startCol < isPalindrome.length; ++startCol){
            for (int r = 0, c = startCol; c < isPalindrome.length; ++r, ++c){
                isPalindrome[r][c] = 
                    s.charAt(r) == s.charAt(c) && (
                        r + 1 >= c - 1 ||
                        isPalindrome[r + 1][c - 1]
                    );
            }
        }

        List<List<String>> results = new ArrayList<List<String>>();
        getPartitionsHelper(s, 0, isPalindrome, results, new ArrayList<String>());
        return results;
    }
}
