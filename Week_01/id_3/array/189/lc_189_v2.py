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

    tail = length - 1
    for i in range(int(length/2)):
        _t = nums[i]
        nums[i] = nums[tail-i]
        nums[tail-i] = _t
