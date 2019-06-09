import lc_441_v1
import lc_441_v2

# f = lc_441_v1.arrange_coins
f = lc_441_v2.arrange_coins


def check(n, r):
    _r = f(n)
    print(_r, r, _r == r)


check(5, 2)
check(8, 3)
