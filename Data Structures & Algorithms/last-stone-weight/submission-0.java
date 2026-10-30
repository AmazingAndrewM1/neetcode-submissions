class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(stones.length, Comparator.reverseOrder());
        pq.addAll(Arrays.stream(stones).boxed().toList());
        while (pq.size() >= 2){
            int largest = pq.poll();
            int secondLargest = pq.poll();
            if (largest > secondLargest){
                pq.add(largest - secondLargest);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
