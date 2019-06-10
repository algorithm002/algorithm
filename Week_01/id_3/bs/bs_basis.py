def bs(nums, x):
    if not nums:
        return -1
    length = len(nums)
    low = 0
    high = length - 1
    


print(bs([8, 11, 19, 23, 27, 33, 45, 55, 67, 98], 19) == 2)
print(bs([8, 11, 19, 23, 27, 33, 45, 55, 67, 98], 33) == 5)
print(bs([8, 11, 19, 23, 27, 33, 45, 55, 67, 98], 18) == -1)
print(bs([8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 19) == 4)
