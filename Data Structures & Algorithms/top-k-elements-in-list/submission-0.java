class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();

        for (int num: nums){
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<Map.Entry<Integer, Integer>>(
            (entry1, entry2) -> entry1.getValue().intValue() - entry2.getValue().intValue()
        );

        for (Map.Entry<Integer, Integer> entry: counter.entrySet()){
            heap.add(entry);
            if (heap.size() > k){
                heap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; ++i){
            result[i] = heap.poll().getKey().intValue();
        }

        return result;
    }
}
