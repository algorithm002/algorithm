import lc_189_v1

f = lc_189_v1.rotate


def check(params, k, arr):
    _p = list(params)
    f(params, k)
    print(_p, params == arr)


check([1, 2, 3, 4, 5, 6, 7], 3, [5, 6, 7, 1, 2, 3, 4])
