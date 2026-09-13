class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; ++i){
            int currentHeight = heights[i];
            int leftPointer = i - 1;
            while (leftPointer >= 0 && heights[leftPointer] >= currentHeight){
                --leftPointer;
            }
            ++leftPointer;

            int rightPointer = i + 1;
            while (rightPointer < heights.length && heights[rightPointer] >= currentHeight){
                ++rightPointer;
            }
            --rightPointer;

            int currentArea = currentHeight * (rightPointer - leftPointer + 1);
            if (currentArea > maxArea){
                maxArea = currentArea;
            }
        }
        return maxArea;
    }
}
