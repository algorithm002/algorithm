def rotate(nums, k):
    """
    :type nums: List[int]
    :type k: int
    :rtype: None Do not return anything, modify nums in-place instead.
    """
    for i in range(k):
        nums.insert(0, nums.pop(len(nums) - 1))