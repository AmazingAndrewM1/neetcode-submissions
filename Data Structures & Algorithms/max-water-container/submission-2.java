class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;

        int left = 0;
        int right = heights.length - 1;
        while (left < right){
            int area = (right - left) * Math.min(heights[left], heights[right]);
            if (area > maxArea){
                maxArea = area;
            }
            if (heights[left] < heights[right]){
                left++;
            }
            else if (heights[left] > heights[right]){
                right--;
            }
            else{
                left++;
                right--;
            }
        }
        return maxArea;
    }
}
