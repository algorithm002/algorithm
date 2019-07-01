class Solution:
    def climbStairs(self, n: int) -> int:
        fn_2 = 1
        fn_1 = 1
        fn = 0
        for i in range(n+1):
            if i <= 1:
                fn = 1
            else:
                fn = fn_1 + fn_2
            fn_2 = fn_1
            fn_1 = fn
        return fn