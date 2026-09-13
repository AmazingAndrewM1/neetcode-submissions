class Solution {
    private int getMaxCount(Map<Character, Integer> countMap){
        int maxCount = 0;
        for (int count: countMap.values()){
            if (count > maxCount){
                maxCount = count;
            }
        }
        return maxCount;
    }
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
        int left = 0;
        int maxCount = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); ++right){
            char ch = s.charAt(right);
            int count = countMap.getOrDefault(ch, 0) + 1;
            countMap.put(ch, count);
            if (count > maxCount){
                maxCount = count;
            }

            int length = right - left + 1;
            if (length - maxCount <= k && length > maxLength){
                maxLength = length;
            }
            else if (length - maxCount > k){
                char leftChar = s.charAt(left);
                countMap.put(leftChar, countMap.get(leftChar) - 1);
                ++left;
            }
        }
        return maxLength;
    }
}
