class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int left = 0;
        int right = numRows * numCols - 1;

        while (left < right){
            int mid = (left + right) / 2;
            int row = mid / numCols;
            int col = mid % numCols;
            System.out.println("Mid: " + mid + " | Row: " + row + " | Col: " + col);
            if (matrix[row][col] < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        System.out.println("Left: " + left);
        return matrix[left / numCols][left % numCols] == target;
    }
}
