class KthLargest {
    private PriorityQueue<Integer> pq;
    private int capacity;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<Integer>(k);
        this.capacity = k;
        for (int num: nums){
            this.add(num);
        }
    }
    
    public int add(int val) {
        if (this.pq.size() == this.capacity && val > this.pq.peek()){
            this.pq.poll();
        }
        if (this.pq.size() < this.capacity){
            this.pq.add(val);
        }
        return this.pq.peek();
    }
}
