class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProducts = new int[nums.length];
        
        leftProducts[0] = nums[0];
        for (int i = 1; i < leftProducts.length; ++i){
            leftProducts[i] = leftProducts[i - 1] * nums[i];
        }

        int[] result = new int[nums.length];
        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 1; --i){
            result[i] = leftProducts[i - 1] * rightProduct;
            rightProduct *= nums[i];
        }
        result[0] = rightProduct;

        return result;
    }
}  
