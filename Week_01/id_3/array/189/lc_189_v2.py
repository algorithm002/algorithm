# 交换法
# 1,2,3,4,5,6,7 进行3位置的移动 等价于 list[0:4]+list[0:3] 两段数据的位置交换
# 位置交换的原地极简方案就是两次反转 [1,2,3,4,5,6,7] 反转0:4-> [4,3,2,1,5,6,7] 反转4:7-> [4,3,2,1,7,6,5] 全部反转-> [5,6,7,1,2,3,4]


def rotate(nums, k):
    if not nums:
        return

    length = len(nums)
    if length == 1:
        return

    k = k % length

    tail = length - k - 1
    for i in range(int((length-k)/2)):
        _t = nums[i]
        nums[i] = nums[tail-i]
        nums[tail-i] = _t

    tail = -k
    for i in range(int(k/2)):
        ti = -i - 1
        _t = nums[ti]
        nums[ti] = nums[tail+i]
        nums[tail+i] = _t

    nums.reverse()
