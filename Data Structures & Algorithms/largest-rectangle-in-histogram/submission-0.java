class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] leftEnd = new int[heights.length];
        int[] rightEnd = new int[heights.length];

        for (int i = 0; i < heights.length; ++i){
            int currentHeight = heights[i];
            int leftPointer = i - 1;
            while (leftPointer >= 0 && heights[leftPointer] >= currentHeight){
                --leftPointer;
            }
            leftEnd[i] = leftPointer + 1;

            int rightPointer = i + 1;
            while (rightPointer < heights.length && heights[rightPointer] >= currentHeight){
                ++rightPointer;
            }
            rightEnd[i] = rightPointer - 1;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; ++i){
            int currentArea = heights[i] * (rightEnd[i] - leftEnd[i] + 1);
            if (currentArea > maxArea){
                maxArea = currentArea;
            }
        }
        return maxArea;
    }
}
