class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    
    public MinStack() {
        stack = new ArrayDeque<Integer>();
        minStack = new ArrayDeque<Integer>();
    }
    
    public void push(int val) {
        stack.addFirst(val);
        if (minStack.isEmpty() || val <= minStack.peekFirst()){
            minStack.addFirst(val);
        }
    }
    
    public void pop() {
        int val = stack.removeFirst();
        if (val == minStack.peekFirst()){
            minStack.removeFirst();
        }
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return minStack.peekFirst();
    }
}
