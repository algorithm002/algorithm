def bs(nums, x):
    low = 0
    high = len(nums) - 1

    while low <= high:
        mid = low + int((high - low)/2)
        if nums[mid] == x:
            return mid
        if nums[mid] > x:
            high = mid - 1
        else:
            low = mid + 1
    return -1


print(bs([8, 11, 19, 23, 27, 33, 45, 55, 67, 98], 19) == 2)
print(bs([8, 11, 19, 23, 27, 33, 45, 55, 67, 98], 33) == 5)
print(bs([8, 11, 19, 23, 27, 33, 45, 55, 67, 98], 18) == -1)
print(bs([8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 19) == 4)
