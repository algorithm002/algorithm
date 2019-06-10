def arrange_coins(n):
    if n <= 0:
        return 0
    s = 0
    k = 0
    while s <= n:
        k += 1
        s += k

    return k - 1
