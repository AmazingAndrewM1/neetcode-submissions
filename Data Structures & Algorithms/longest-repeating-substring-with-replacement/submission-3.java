class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0;
        int maxCount = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); ++right){
            int index = s.charAt(right) - 'A';
            counts[index]++;
            if (counts[index] > maxCount){
                maxCount = counts[index];
            }

            int length = right - left + 1;
            if (length - maxCount > k){
                counts[s.charAt(left) - 'A']--;
                ++left;
            }
            else if (length > maxLength){
                maxLength = length;
            }
        }
        return maxLength;
    }
}
