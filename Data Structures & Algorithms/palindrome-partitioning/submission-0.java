class Solution {
    private boolean isPalindrome(String s, int i, int j){
        int l = i;
        int r = j;
        while (l < r && s.charAt(l) == s.charAt(r)){
            ++l;
            --r;
        }

        return l >= r;
    }
    private void getPartitionHelper(String s, int i, List<List<String>> result, List<String> partition){
        if (i >= s.length()){
            result.add(new ArrayList<String>(partition));
            return;
        }

        for (int j = i; j < s.length(); ++j){
            if (isPalindrome(s, i, j)){
                partition.addLast(s.substring(i, j + 1));
                getPartitionHelper(s, j + 1, result, partition);
                partition.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        getPartitionHelper(s, 0, result, new ArrayList<String>());
        return result;
    }
}
