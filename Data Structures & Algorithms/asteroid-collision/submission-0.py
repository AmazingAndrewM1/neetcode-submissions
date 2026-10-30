from collections import deque
class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = deque()

        # for asteroid in asteroids:
        #     if len(stack) == 0:
        #         stack.append(asteroid);
        #     else:
        #         top = stack[-1]
        #         if (asteroid > 0) == (top > 0):
        #             stack.append(asteroid)
        #             print("ast", asteroid)
        #         else:
        #             while (len(stack) > 0 and abs(asteroid) > abs(stack[-1])):
        #                 stack.pop()
        #                 print("ast1", asteroid)
        #             if len(stack) == 0:
        #                 stack.append(asteroid)
        #                 print("ast2", asteroid)
        #             elif abs(stack[-1]) == abs(asteroid):
        #                 stack.pop()
        #                 print("ast3", asteroid)
        #     print(stack)
        # return list(stack)

        res = []

        for asteroid in asteroids:
            if asteroid > 0:
                stack.append(asteroid)
            else:
                while len(stack) > 0 and -asteroid > stack[-1]:
                    stack.pop()
                if len(stack) == 0:
                    res.append(asteroid)
                elif -asteroid == stack[-1]:
                    stack.pop()
        res.extend(stack)
        return res
            


                
