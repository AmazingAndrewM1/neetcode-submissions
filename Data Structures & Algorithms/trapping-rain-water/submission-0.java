class Solution {
    private int getMax(int[] data, int start, int end){
        int max = 0;
        for (int i = start; i <= end; ++i){
            if (data[i] > max){
                max = data[i];
            }
        }
        return max;
    }
    public int trap(int[] height) {
        int totalArea = 0;
        for (int i = 0; i < height.length; ++i){
            int maxLeft = getMax(height, 0, i - 1);
            int maxRight = getMax(height, i + 1, height.length - 1);
            if (height[i] < maxLeft && maxLeft <= maxRight){
                totalArea += maxLeft - height[i];
            }
            else if (height[i] < maxRight && maxRight < maxLeft){
                totalArea += maxRight - height[i];
            }
        }
        return totalArea;
    }
}
