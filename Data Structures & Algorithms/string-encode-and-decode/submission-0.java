class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String str: strs){
            result.append(str.length()).append('.').append(str);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<String>();

        int i = 0;
        while (i < str.length()){
            int strLength = 0;
            char ch = str.charAt(i);
            while (ch >= '0' && ch <= '9'){
                strLength = strLength * 10 + ch - '0';
                i++;
                ch = str.charAt(i);
            }
            i++;
            result.add(str.substring(i, i + strLength));
            i += strLength;
        }
        return result;
    }
}
