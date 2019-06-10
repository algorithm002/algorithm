def remove_duplicates(nums):
    if not nums:
        return 0

    i = 1
    cur = nums[0]
    for n in nums:
        if n != cur:
            nums[i] = cur = n
            i += 1

    return i
