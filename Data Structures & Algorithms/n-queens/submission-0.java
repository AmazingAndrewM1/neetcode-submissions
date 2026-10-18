class Solution {
    private boolean isSafe(char[][] board, int r, int c){
        for (int colChange = -1; colChange <= 1; ++colChange){
            int newR = r - 1;
            int newC = c + colChange;
            while (newR >= 0 && newC >= 0 && newC < board[newR].length){
                if (board[newR][newC] == 'Q'){
                    return false;
                }
                --newR;
                newC += colChange;
            }
        }

        return true;
    }

    private void generateSolutions(List<List<String>> solutions, char[][] board, int r){
        if (r == board.length){
            List<String> newSolution = new ArrayList<String>();
            for (char[] row: board){
                newSolution.add(new String(row));
            }
            solutions.add(newSolution);
            return;
        }

        for (int c = 0; c < board[r].length; ++c){
            if (isSafe(board, r, c)){
                board[r][c] = 'Q';
                generateSolutions(solutions, board, r + 1);
                board[r][c] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row: board){
            Arrays.fill(row, '.');
        }

        List<List<String>> solutions = new ArrayList<List<String>>();
        generateSolutions(solutions, board, 0);
        return solutions;
    }
}
