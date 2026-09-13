class PrefixTree {
    private class CharNode{
        public CharNode[] charChildren;
        public boolean isEndOfWord;

        public CharNode(){
            charChildren = new CharNode[26];
            isEndOfWord = false;
        }
    }

    private CharNode root;
    public PrefixTree() {
        root = new CharNode();
    }

    public void insert(String word) {
        CharNode curr = root;
        for (int i = 0; i < word.length(); ++i){
            int index = word.charAt(i) - 'a';
            if (curr.charChildren[index] == null){
                curr.charChildren[index] = new CharNode();
            }
            curr = curr.charChildren[index];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        CharNode curr = root;
        for (int i = 0; i < word.length() && curr != null; ++i){
            curr = curr.charChildren[word.charAt(i) - 'a'];
        }
        return curr != null && curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        CharNode curr = root;
        for (int i = 0; i < prefix.length() && curr != null; ++i){
            curr = curr.charChildren[prefix.charAt(i) - 'a'];
        }
        return curr != null;
    }
}
