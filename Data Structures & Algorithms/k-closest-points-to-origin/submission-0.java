class Solution {
    private int compareFunction(int[] point1, int[] point2){
        int squaredDistance1 = point1[0] * point1[0] + point1[1] * point1[1];
        int squaredDistance2 = point2[0] * point2[0] + point2[1] * point2[1];
        return Integer.compare(squaredDistance1, squaredDistance2);
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            k,
            (point1, point2) -> compareFunction(point2, point1)
        );

        for (int[] point: points){
            if (pq.size() == k && compareFunction(point, pq.peek()) < 0){
                pq.poll();
            }
            if (pq.size() < k){
                pq.add(point);
            }
        }

        int[][] result = new int[k][2];
        Iterator<int[]> pointIterator = pq.iterator();
        for (int i = 0; i < result.length; ++i){
            result[i] = pointIterator.next();
        }
        
        return result;
    }
}
