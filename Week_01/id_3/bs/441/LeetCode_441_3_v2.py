# 此题超时了 有待用二分优化


def arrange_coins(n):
    if n <= 0:
        return 0
    k = 1

    while True:
        s = int(((1 + k) * k)/2)
        print(s, k)
        if s == n:
            return k
        if s > n:
            return k - 1
        k += 1
