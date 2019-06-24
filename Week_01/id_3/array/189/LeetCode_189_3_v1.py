# 最大公约数
# 每次数组挪动一步，挪动k次，毫无疑问是可以实现的，但是时间复杂度 O(kn) 是无法接受的
# 如果每次移动的是nums[i]和nums[i+k]，很可能无法遍历所有数据，例如len(nums)==9 k==3，此时只会在0,3,6三个下标之间进行移动
# 根据规律总结 如len(nums)与k的最小公倍数 是每次进行k偏移交换的循环
# 也就是len(nums)与k的最大公约数gcd会是产生循环迭代的次数。例如len(nums)==9 k==3 gcd==3 下标每次偏移3，3次就会出现循环。
# 所以需要 len(nums)/gcd 次就可以交换所有的数据

import math


def rotate(nums, k):
    if not nums:
        return

    length = len(nums)
    k = k % length

    if not k:
        return

    gcd = math.gcd(length, k)

    for offset in range(gcd):
        tmp = nums[offset]
        for i in range(1, int(length/gcd) + 1):
            index = (i*k + offset) % length
            nums[index], tmp = tmp, nums[index]
