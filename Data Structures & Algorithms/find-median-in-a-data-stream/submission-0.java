class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<Integer>(Comparator.naturalOrder());
    }
    
    public void addNum(int num) {
        PriorityQueue<Integer> heapToAdd = maxHeap.isEmpty() || num <= maxHeap.peek() ? maxHeap : minHeap;
        heapToAdd.offer(num);

        PriorityQueue<Integer> smallerHeap = maxHeap.size() < minHeap.size() ? maxHeap : minHeap;
        PriorityQueue<Integer> largerHeap = smallerHeap == maxHeap ? minHeap : maxHeap;

        if (largerHeap.size() - smallerHeap.size() > 1){
            smallerHeap.offer(largerHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek()) / 2.0d;
        }
        else{
            PriorityQueue<Integer> largerHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
            return (double)largerHeap.peek();
        }
    }
}
