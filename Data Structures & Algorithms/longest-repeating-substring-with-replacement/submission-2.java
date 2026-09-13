class Solution {
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
            if (length - maxCount > k){
                char leftChar = s.charAt(left);
                countMap.put(leftChar, countMap.get(leftChar) - 1);
                ++left;
            }
            else if (length > maxLength){
                maxLength = length;
            }
        }
        return maxLength;
    }
}
