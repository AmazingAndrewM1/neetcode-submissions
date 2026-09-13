class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }

        Map<Character, Integer> s1CharCounter = new HashMap<Character, Integer>();
        Map<Character, Integer> s2CharCounter = new HashMap<Character, Integer>();

        for (int i = 0; i < s1.length(); ++i){
            char ch = s1.charAt(i);
            s1CharCounter.put(ch, s1CharCounter.getOrDefault(ch, 0) + 1);
        }

        int numMatches = 0;
        for (int right = 0; right < s1.length(); ++right){
            char ch = s2.charAt(right);
            int newCount = s2CharCounter.getOrDefault(ch, 0) + 1;
            if (newCount <= s1CharCounter.getOrDefault(ch, 0)){
                numMatches++;
            }
            s2CharCounter.put(ch, newCount);
        }
        if (numMatches == s1.length()){
            return true;
        }

        for (int right = s1.length(); right < s2.length(); ++right){
            int left = right - s1.length();
            char chToRemove = s2.charAt(left);
            int newCount = s2CharCounter.get(chToRemove) - 1;
            if (newCount < s1CharCounter.getOrDefault(chToRemove, 0)){
                numMatches--;
            }
            s2CharCounter.put(chToRemove, newCount);

            char chToAdd = s2.charAt(right);
            newCount = s2CharCounter.getOrDefault(chToAdd, 0) + 1;
            if (newCount <= s1CharCounter.getOrDefault(chToAdd, 0)){
                numMatches++;
            }
            s2CharCounter.put(chToAdd, newCount);

            if (numMatches == s1.length()){
                return true;
            }
        }

        return false;
    }
}
