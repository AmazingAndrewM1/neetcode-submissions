class Solution {
    public record HeightInfo(int height, int leftIndex){}
    public int largestRectangleArea(int[] heights){
        Deque<HeightInfo> stack = new ArrayDeque<HeightInfo>();
        int maxArea = 0;
        int rightIndex = 0;

        for (int i = 0; i < heights.length; ++i){
            int height = heights[i];
            HeightInfo lastRemoved = null;
            while (!stack.isEmpty() && height <= stack.peekFirst().height()){
                lastRemoved = stack.removeFirst();
                int currentArea = lastRemoved.height() * (rightIndex - lastRemoved.leftIndex() + 1);
                if (currentArea > maxArea){
                    maxArea = currentArea;
                }
            }
            if (lastRemoved == null){
                stack.addFirst(new HeightInfo(height, i));
            }
            else{
                stack.addFirst(new HeightInfo(height, lastRemoved.leftIndex()));
            }
            rightIndex = i;
        }
        while (!stack.isEmpty()){
            HeightInfo removed = stack.removeFirst();
            int currentArea = removed.height() * (rightIndex - removed.leftIndex() + 1);
            if (currentArea > maxArea){
                maxArea = currentArea;
            }
        }

        return maxArea;
    }
}
