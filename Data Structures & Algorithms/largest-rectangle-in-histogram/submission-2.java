class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] leftEnd = new int[heights.length];
        int[] rightEnd = new int[heights.length];
        Deque<int[]> stack = new ArrayDeque<int[]>();

        for (int i = 0; i < heights.length; ++i){
            int currentHeight = heights[i];
            while (!stack.isEmpty() && currentHeight < stack.peekFirst()[0]){
                int[] heightInfo = stack.removeFirst();
                rightEnd[heightInfo[1]] = i - 1;
            }
            stack.addFirst(new int[]{currentHeight, i});
            rightEnd[i] = heights.length - 1;
        }

        stack.clear();

        for (int i = heights.length - 1; i >= 0; --i){
            int currentHeight = heights[i];
            while (!stack.isEmpty() && currentHeight < stack.peekFirst()[0]){
                int[] heightInfo = stack.removeFirst();
                leftEnd[heightInfo[1]] = i + 1;
            }
            stack.addFirst(new int[]{currentHeight, i});
            leftEnd[i] = 0;
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
