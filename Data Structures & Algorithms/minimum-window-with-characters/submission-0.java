class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCounter = new HashMap<Character, Integer>();
        Map<Character, Integer> sCounter = new HashMap<Character, Integer>();
        Deque<Integer> queue = new ArrayDeque<Integer>();

        for (int i = 0; i < t.length(); ++i){
            char ch = t.charAt(i);
            tCounter.put(ch, tCounter.getOrDefault(ch, 0) + 1);
        }

        int numMatches = 0;
        int leftSubstring = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); ++right){
            char ch = s.charAt(right);
            if (tCounter.containsKey(ch)){
                int newCount = sCounter.getOrDefault(ch, 0) + 1;
                if (newCount <= tCounter.get(ch)){
                    numMatches++;
                }
                sCounter.put(ch, newCount);

                queue.addLast(right);
                char queueChar = s.charAt(queue.peekFirst());
                while (sCounter.get(queueChar) > tCounter.get(queueChar)){
                    queue.removeFirst();
                    sCounter.put(queueChar, sCounter.get(queueChar) - 1);
                    queueChar = s.charAt(queue.peekFirst());
                }
                if (numMatches == t.length() && right - queue.peekFirst() + 1 < minLength){
                    leftSubstring = queue.peekFirst();
                    minLength = right - leftSubstring + 1;
                }
            }
        }
        String result = "";
        if (numMatches == t.length()){
            result = s.substring(leftSubstring, leftSubstring + minLength);
        }
        return result;
    }
}
