from collections import deque
class Solution:
    def calPoints(self, operations: List[str]) -> int:
        stack = deque();

        res = 0;

        for i in operations:
            if i == '+':
                n1 = stack[-1];
                n2 = stack[-2];

                stack.append(n1+n2);
            elif i == 'D':
                stack.append(stack[-1]*2);
            elif i == 'C':
                stack.pop()
            else: 
                stack.append(int(i))
        return sum(stack)