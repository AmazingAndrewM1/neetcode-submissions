class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /* First, let's do the easiest solution of merging, sorting and then finding the median element */

        int[] result = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, result, 0, nums1.length);
        System.arraycopy(nums2, 0, result, nums1.length, nums2.length);
        Arrays.sort(result);
        
        int left = result[result.length / 2];
        int right = result[(result.length - 1) / 2];
        return 0.5d * (left + right);
    }
}
