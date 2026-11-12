class Solution {
    private boolean isNewIsland(char[][] grid, boolean[][] hasVisited, int r, int c){
        boolean isInBounds = r >= 0 && r < grid.length && c >= 0 && c < grid[r].length;
        if (!isInBounds || grid[r][c] != '1' || hasVisited[r][c]){
            return false;
        }

        hasVisited[r][c] = true;
        isNewIsland(grid, hasVisited, r + 1, c);
        isNewIsland(grid, hasVisited, r - 1, c);
        isNewIsland(grid, hasVisited, r, c + 1);
        isNewIsland(grid, hasVisited, r, c - 1);
        return true;
    }

    public int numIslands(char[][] grid) {
        boolean[][] hasVisited = new boolean[grid.length][grid[0].length];

        int numIslands = 0;
        for (int r = 0; r < grid.length; ++r){
            for (int c = 0; c < grid[r].length; ++c){
                if (isNewIsland(grid, hasVisited, r, c)){
                    ++numIslands;
                }
            }
        }

        return numIslands;
    }
}
