class WordDictionary {
    private class CharNode{
        public CharNode[] charChildren;
        public boolean isEndOfWord;

        public CharNode(){
            this.charChildren = new CharNode[26];
            this.isEndOfWord = false;
        }
    }

    private CharNode root;
    public WordDictionary() {
        root = new CharNode();
    }

    public void addWord(String word) {
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

    private boolean hasFoundWord(String word, int index, CharNode start){
        CharNode curr = start;
        for (int i = index; i < word.length() && curr != null; ++i){
            char ch = word.charAt(i);
            if (ch == '.'){
                for (CharNode child: curr.charChildren){
                    if (hasFoundWord(word, i + 1, child)){
                        return true;
                    }
                }
                return false;
            }
            curr = curr.charChildren[ch - 'a'];
        }
        return curr != null && curr.isEndOfWord;
    }

    public boolean search(String word) {
        return hasFoundWord(word, 0, root);
    }
}
