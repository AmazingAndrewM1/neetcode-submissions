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
        if (height.length == 0){
            return 0;
        }

        int[] leftMax = new int[height.length];
        int max = 0;
        for (int i = 0; i < leftMax.length; ++i){
            leftMax[i] = max;
            if (height[i] > max){
                max = height[i];
            }
        }

        int[] rightMax = new int[height.length];
        max = 0;
        for (int i = rightMax.length - 1; i >= 0; --i){
            rightMax[i] = max;
            if (height[i] > max){
                max = height[i];
            }
        }

        int totalArea = 0;
        for (int i = 0; i < height.length; ++i){
            if (height[i] < leftMax[i] && leftMax[i] <= rightMax[i]){
                totalArea += leftMax[i] - height[i];
            }
            else if (height[i] < rightMax[i] && rightMax[i] < leftMax[i]){
                totalArea += rightMax[i] - height[i];
            }
        }
        return totalArea;
    }
}
