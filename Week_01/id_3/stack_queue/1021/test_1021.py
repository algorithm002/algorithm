import lc_1021_v1
import lc_1021_v2

# f = lc_1021_v1.remove_outer_parentheses
f = lc_1021_v2.remove_outer_parentheses


def check(s, r):
    _r = f(s)
    print(_r, r, _r == r)


check('(()())(())', '()()()')
check('(()())(())(()(()))', '()()()()(())')
check('()()', '')
