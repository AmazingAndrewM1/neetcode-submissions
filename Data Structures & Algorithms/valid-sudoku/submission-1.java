class Solution {
    private boolean isValidSection(char[][] board, int rMin, int rMax, int cMin, int cMax){
        int intFlags = 0b0;
        for (int r = rMin; r < rMax; ++r){
            for (int c = cMin; c < cMax; ++c){
                char ch = board[r][c];
                if (ch != '.'){
                    int bitMask = 1 << (ch - '1');
                    if ((intFlags & bitMask) != 0){
                        return false;
                    }
                    intFlags |= bitMask;
                }
            }
        }
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < board.length; ++r){
            if (!isValidSection(board, r, r + 1, 0, 9)){
                return false;
            }
        }

        for (int c = 0; c < board[0].length; ++c){
            if (!isValidSection(board, 0, 9, c, c + 1)){
                return false;
            }
        }

        for (int box = 0; box < 9; ++box){
            int startRow = box / 3 * 3;
            int startColumn = box % 3 * 3;
            if (!isValidSection(board, startRow, startRow + 3, startColumn, startColumn + 3)){
                return false;
            }
        }

        return true;
    }
}
