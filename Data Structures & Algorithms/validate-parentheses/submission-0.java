class Solution {
    private boolean isOpeningChar(char ch){
        switch (ch){
            case '(':
            case '{':
            case '[':
                return true;
            default:
                return false;
        }
    }

    private char getOpeningChar(char ch){
        switch (ch){
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                return '\0';
        }
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if (isOpeningChar(ch)){
                stack.addFirst(ch);
            }
            else if (stack.isEmpty() || getOpeningChar(ch) != stack.removeFirst()){
                return false;
            }
        }

        return stack.isEmpty();
    }
}
