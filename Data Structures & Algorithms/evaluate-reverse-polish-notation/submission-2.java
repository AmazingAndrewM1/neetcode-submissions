class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (String token: tokens){
            int operand1 = 0;
            int operand2 = 0;
            switch (token){
                case "+":
                case "-":
                case "*":
                case "/":
                    operand2 = stack.removeFirst();
                    operand1 = stack.removeFirst();
                    break;
            }

            switch (token){
                case "+":
                    stack.addFirst(operand1 + operand2);
                    break;
                case "-":
                    stack.addFirst(operand1 - operand2);
                    break;
                case "*":
                    stack.addFirst(operand1 * operand2);
                    break;
                case "/":
                    stack.addFirst(operand1 / operand2);
                    break;
                default:
                    stack.addFirst(Integer.parseInt(token));
                    break;
            }
        }

        return stack.peekFirst();
    }
}
