class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Step 1: Check all rows
        for (char[] row: board){
            int intFlags = 0b0;
            for (char ch: row){
                if (ch != '.'){
                    int bitMask = 0b1 << (ch - '1');
                    if ((intFlags & bitMask) != 0){
                        return false;
                    }
                    intFlags |= bitMask;
                }
            }
        }

        for (int c = 0; c < board[0].length; ++c){
            int intFlags = 0b0;
            for (int r = 0; r < board.length; ++r){
                char ch = board[r][c];
                if (ch != '.'){
                    int bitMask = 0b1 << (ch - '1');
                    if ((intFlags & bitMask) != 0){
                        return false;
                    }
                    intFlags |= bitMask;
                }
            }
        }

        for (int box = 0; box < 9; ++box){
            int intFlags = 0b0;
            for (int r = box / 3 * 3; r < box / 3 * 3 + 3; ++r){
                for (int c = box % 3 * 3; c < box % 3 * 3 + 3; ++c){
                    char ch = board[r][c];
                    if (ch != '.'){
                        int bitMask = 0b1 << (ch - '1');
                        if ((intFlags & bitMask) != 0){
                            return false;
                        }
                        intFlags |= bitMask;
                    }
                }
            }
        }
        return true;
    }
}
