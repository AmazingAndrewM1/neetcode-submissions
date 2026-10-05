class Solution {
    private boolean isWordFound(char[][] board, boolean[][] hasVisited, int r, int c, String word, int i){     
        if (i == word.length()){
            return true;
        }

        boolean isInBounds = r >= 0 && r < board.length && c >= 0 && c < board[r].length;
        if (!isInBounds || hasVisited[r][c] || board[r][c] != word.charAt(i)){
            return false;
        }

        hasVisited[r][c] = true;
        boolean exists = 
            isWordFound(board, hasVisited, r + 1, c, word, i + 1) ||
            isWordFound(board, hasVisited, r - 1, c, word, i + 1) ||
            isWordFound(board, hasVisited, r, c + 1, word, i + 1) ||
            isWordFound(board, hasVisited, r, c - 1, word, i + 1);
        hasVisited[r][c] = false;
        return exists;
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] hasVisited = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length; ++r){
            for (int c = 0; c < board[r].length; ++c){
                if (isWordFound(board, hasVisited, r, c, word, 0)){
                    return true;
                }
            }
        }

        return false;
    }
}
