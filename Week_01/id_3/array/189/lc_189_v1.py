import math


def rotate(nums, k):
    if not nums:
        return

    length = len(nums)
    gcd = math.gcd(length, k)
    for t in range(gcd):
        tmp = nums[t]
        for i in range(int(length/gcd)):
            index = ((i+1)*k + t) % length
            _t = nums[index]
            nums[index] = tmp
            tmp = _t
