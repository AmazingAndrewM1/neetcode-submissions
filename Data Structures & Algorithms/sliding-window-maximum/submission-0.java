class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, 
            (a, b) -> b.compareTo(a)
        );
        Deque<Integer> queue = new ArrayDeque<Integer>(k);
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; ++i){
            Integer intObj = Integer.valueOf(nums[i]);
            maxHeap.add(intObj);
            queue.addLast(intObj);
            if (i + 1 >= k){
                result[i - k + 1] = maxHeap.peek().intValue();
                maxHeap.remove(queue.removeFirst());
            }
        }

        return result;
    }
}
