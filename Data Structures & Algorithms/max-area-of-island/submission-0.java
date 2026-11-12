class Solution {
    private int currentArea = 0;
    private int getArea(int[][] grid, boolean[][] hasVisited, int r, int c){
        this.currentArea = 0;
        getAreaHelper(grid, hasVisited, r, c);
        return this.currentArea;
    }

    private void getAreaHelper(int[][] grid, boolean[][] hasVisited, int r, int c){
        boolean isInBounds = r >= 0 && r < grid.length && c >= 0 && c < grid[r].length;
        if (!isInBounds || hasVisited[r][c] || grid[r][c] != 1){
            return;
        }

        hasVisited[r][c] = true;
        ++this.currentArea;
        getAreaHelper(grid, hasVisited, r + 1, c);
        getAreaHelper(grid, hasVisited, r - 1, c);
        getAreaHelper(grid, hasVisited, r, c + 1);
        getAreaHelper(grid, hasVisited, r, c - 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] hasVisited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int r = 0; r < grid.length; ++r){
            for (int c = 0; c < grid[r].length; ++c){
                maxArea = Math.max(maxArea, getArea(grid, hasVisited, r, c));
            }
        }

        return maxArea;
    }
}
