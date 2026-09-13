class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> counter = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); ++i){
            char ch = t.charAt(i);
            if (counter.containsKey(ch) == false){
                return false;
            }

            int numTimes = counter.get(ch) - 1;
            if (numTimes > 0){
                counter.put(ch, numTimes);
            }
            else{
                counter.remove(ch);
            }
        }

        return counter.isEmpty();
    }
}
