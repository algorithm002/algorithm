def rotate(nums, k):
    if not nums:
        return

    last_index = len(nums) - 1
    for t in range(k):
        tmp = nums[last_index]
        for i in range(last_index, 0, -1):
            nums[i] = nums[i - 1]
        nums[0] = tmp
