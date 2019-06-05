import lc_15_v1

f = lc_15_v1.three_sum


def check(nums, r):
    _r = f(nums)
    print(_r, _r == r)


check([-1, 0, 1, 2, -1, -4],
      [
          [-1, 0, 1],
          [-1, -1, 2]
      ])


check([0, 0], [])
check([0, 0, 0], [[0, 0, 0]])
