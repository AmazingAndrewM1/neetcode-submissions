class Solution {
    private class LetterNode{
        public LetterNode[] children;
        public boolean isEndOfWord;

        public LetterNode(){
            children = new LetterNode[26];
            isEndOfWord = false;
        }
    }

    private LetterNode root;
    private List<String> foundWords;

    public Solution(){
        foundWords = new ArrayList<String>();
    }

    private void generateNode(String word){
        LetterNode curr = root;
        for (int i = 0; i < word.length(); ++i){
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null){
                curr.children[index] = new LetterNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    private void doWordSearch(char[][] board, int r, int c, StringBuilder word, LetterNode curr, boolean[][] hasVisited){
        if (hasVisited[r + 1][c + 1]){
            return;
        }

        LetterNode next = curr.children[board[r][c] - 'a'];
        if (next == null){
            return;
        }

        hasVisited[r + 1][c + 1] = true;
        word.append(board[r][c]);
        if (next.isEndOfWord){
            foundWords.add(word.toString());
            next.isEndOfWord = false;
        }

        doWordSearch(board, r - 1, c, word, next, hasVisited);
        doWordSearch(board, r + 1, c, word, next, hasVisited);
        doWordSearch(board, r, c - 1, word, next, hasVisited);
        doWordSearch(board, r, c + 1, word, next, hasVisited);

        hasVisited[r + 1][c + 1] = false;
        word.deleteCharAt(word.length() - 1);
    }

    public List<String> findWords(char[][] board, String[] words) {
        root = new LetterNode();
        for (String word: words){
            generateNode(word);
        }

        boolean[][] hasVisited = new boolean[board.length + 2][board[0].length + 2];
        for (int r = 0; r < hasVisited.length; ++r){
            hasVisited[r][0] = true;
            hasVisited[r][hasVisited[0].length - 1] = true;
        }
        for (int c = 1; c < hasVisited[0].length - 1; ++c){
            hasVisited[0][c] = true;
            hasVisited[hasVisited.length - 1][c] = true;
        }

        for (int r = 0; r < board.length; ++r){
            for (int c = 0; c < board[r].length; ++c){
                doWordSearch(board, r, c, new StringBuilder(), root, hasVisited);
            }
        }

        return foundWords;
    }
}
