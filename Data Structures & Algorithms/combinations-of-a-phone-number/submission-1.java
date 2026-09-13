class Solution {
    private void getCombinations(List<String> result, StringBuilder str, String digits, int index, Map<Character, List<Character>> phoneMap){
        if (index == digits.length()){
            result.add(str.toString());
            return;
        }
        for (Character ch: phoneMap.get(digits.charAt(index))){
            str.setCharAt(index, ch);
            getCombinations(result, str, digits, index + 1, phoneMap);
        }
    }
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        
        Map<Character, List<Character>> phoneMap = Map.of(
            '2', Arrays.asList('a', 'b', 'c'),
            '3', Arrays.asList('d', 'e', 'f'),
            '4', Arrays.asList('g', 'h', 'i'),
            '5', Arrays.asList('j', 'k', 'l'),
            '6', Arrays.asList('m', 'n', 'o'),
            '7', Arrays.asList('p', 'q', 'r', 's'),
            '8', Arrays.asList('t', 'u', 'v'),
            '9', Arrays.asList('w', 'x', 'y', 'z')
        );

        List<String> result = new ArrayList<String>();
        StringBuilder str = new StringBuilder();
        str.setLength(digits.length());
        getCombinations(result, str, digits, 0, phoneMap);
        return result;
    }
}
