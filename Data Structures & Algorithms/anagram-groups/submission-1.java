class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
        for (String str: strs){
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); ++i){
                counts[str.charAt(i) - 'a']++;
            }
            StringBuilder strAnagram = new StringBuilder();
            for (int i = 0; i < counts.length; ++i){
                if (counts[i] > 0){
                    strAnagram.append(counts[i]).append(i + 'a');
                }
            }
            String maybeKey = strAnagram.toString();
            if (anagramMap.containsKey(maybeKey) == false){
                anagramMap.put(maybeKey, new ArrayList<String>());
            }
            anagramMap.get(maybeKey).add(str);
        }
        return new ArrayList<List<String>>(anagramMap.values());
    }
}
