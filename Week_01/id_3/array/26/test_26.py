import lc_26_v1

f = lc_26_v1.remove_duplicates


def check(params, length, arr):
    _p = list(params)
    print(_p, f(params) == length and params[:length] == arr)


check([], 0, [])
check([1, 1, 2, 3], 3, [1, 2, 3])
