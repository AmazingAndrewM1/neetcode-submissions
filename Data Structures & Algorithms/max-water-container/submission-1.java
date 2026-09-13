class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        for (int left = 0; left < heights.length; ++left){
            for (int right = left + 1; right < heights.length; ++right){
                maxArea = Math.max(maxArea, (right - left) * Math.min(heights[left], heights[right]));
            }
        }
        return maxArea;
    }
}
