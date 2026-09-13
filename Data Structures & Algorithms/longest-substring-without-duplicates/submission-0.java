class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); ++right){
            char ch = s.charAt(right);
            if (charMap.containsKey(ch) && charMap.get(ch) >= left){
                maxLength = Math.max(maxLength, right - left);
                left = charMap.get(ch) + 1;
            }
            
            charMap.put(ch, right);
        }
        return Math.max(maxLength, s.length() - left);
    }
}
