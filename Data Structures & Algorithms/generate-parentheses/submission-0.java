class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generatePatterns(result, new StringBuilder(n + n), 0, 0, n);
        return result;
    }

    private void generatePatterns(List<String> result, StringBuilder str, int numOpening, int numClosing, int limit){
        if (numOpening == limit && numClosing == limit){
            result.add(str.toString());
            return;
        }

        if (numOpening < limit){
            str.append('(');
            generatePatterns(result, str, numOpening + 1, numClosing, limit);
            str.deleteCharAt(str.length() - 1);
        }

        if (numClosing < numOpening){
            str.append(')');
            generatePatterns(result, str, numOpening, numClosing + 1, limit);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
