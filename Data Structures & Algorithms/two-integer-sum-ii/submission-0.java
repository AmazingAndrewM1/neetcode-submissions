class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int sum = numbers[left] + numbers[right];

        while (sum != target){
            if (sum > target){
                right--;
            }
            else{
                left++;
            }
            sum = numbers[left] + numbers[right];
        }

        return new int[]{left + 1, right + 1};
    }
}
