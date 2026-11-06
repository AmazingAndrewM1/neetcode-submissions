class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);

        for (int num: nums){
            if (pq.size() == k && num > pq.peek()){
                pq.poll();
            }
            if (pq.size() < k){
                pq.offer(num);
            }
        }

        return pq.peek();
    }
}
