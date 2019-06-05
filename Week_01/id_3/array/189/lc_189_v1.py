import math


def rotate(nums, k):
    if not nums:
        return

    length = len(nums)
    k = k % length

    if not k:
        return

    gcd = math.gcd(length, k)

    for t in range(gcd):
        tmp = nums[t]
        for i in range(1, int(length/gcd) + 1):
            index = (i*k + t) % length
            _t = nums[index]
            nums[index] = tmp
            tmp = _t
