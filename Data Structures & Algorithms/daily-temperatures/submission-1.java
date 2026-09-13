class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<int[]>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; ++i){
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > stack.peekFirst()[0]){
                int index = stack.removeFirst()[1];
                result[index] = i - index;
            }
            stack.addFirst(new int[]{temperature, i});
        }

        while (!stack.isEmpty()){
            result[stack.removeFirst()[1]] = 0;
        }

        return result;
    }
}
