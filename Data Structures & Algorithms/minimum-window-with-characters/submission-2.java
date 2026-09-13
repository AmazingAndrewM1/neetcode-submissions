class Solution {
    private boolean isEqual(Map<Character, Integer> tCounter, Map<Character, Integer> sCounter){
        for (Map.Entry<Character, Integer> tEntry : tCounter.entrySet()){
            if (sCounter.getOrDefault(tEntry.getKey(), 0).compareTo(tEntry.getValue()) < 0){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCounter = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); ++i){
            char ch = t.charAt(i);
            tCounter.put(ch, tCounter.getOrDefault(ch, 0) + 1);
        }

        int bestLeft = 0;
        int minLength = Integer.MAX_VALUE;
        for (int left = 0; left < s.length(); ++left){
            Map<Character, Integer> sCounter = new HashMap<Character, Integer>();
            for (int right = left; right < s.length() && right - left + 1 < minLength; ++right){
                char ch = s.charAt(right);
                sCounter.put(ch, sCounter.getOrDefault(ch, 0) + 1);

                if (isEqual(tCounter, sCounter)){
                    bestLeft = left;
                    minLength = right - left + 1;
                    break;
                }
            }
        }
        String result = "";
        if (minLength != Integer.MAX_VALUE){
            result = s.substring(bestLeft, bestLeft + minLength);
        }
        return result;
    }
}
