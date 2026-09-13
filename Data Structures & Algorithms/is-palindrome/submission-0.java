class Solution {
    private boolean areSame(char ch1, char ch2){
        if (ch1 >= 'a' && ch1 <= 'z'){
            ch1 = (char)(ch1 - 'a' + 'A');
        }
        if (ch2 >= 'a' && ch2 <= 'z'){
            ch2 = (char)(ch2 - 'a' + 'A');
        }
        return ch1 == ch2;
    }
    private boolean isAlphanumericAt(String s, int index){
        char ch = s.charAt(index);
        return (ch >= 'a' && ch <= 'z') ||
               (ch >= 'A' && ch <= 'Z') ||
               (ch >= '0' && ch <= '9');
    }
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            while (left < s.length() && !isAlphanumericAt(s, left)){
                left++;
            }
            while (right >= 0 && !isAlphanumericAt(s, right)){
                right--;
            }
            if (left < right && !areSame(s.charAt(left), s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
