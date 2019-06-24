def bs(nums, x):
    if not nums:
        return -1
    length = len(nums)
    low = 0
    high = length - 1
    while low <= high:
        mid = low + int((high - low)/2)
        v = nums[mid]
        if v == x:
            return mid
        if v > x:
            high = mid - 1
        else:
            low = mid + 1

    return -1


def bs_first(nums, x):
    if not nums:
        return -1
    length = len(nums)
    low = 0
    high = length - 1
    while low <= high:
        mid = low + int((high - low)/2)
        v = nums[mid]
        if v >= x:
            high = mid - 1
        else:
            low = mid + 1

    if low < length and nums[low] == x:
        return low

    return -1


def bs_last(nums, x):
    low = 0
    high = len(nums) - 1
    while low <= high:
        mid = low + (high - low)//2
        v = nums[mid]
        if v > x:
            high = mid - 1
        else:
            low = mid + 1
    if high >= 0 and nums[high] == x:
        return high
    return -1


def bs_gte(nums, x):
    low = 0
    high = len(nums) - 1
    while low <= high:
        mid = low + (high - low)//2
        v = nums[mid]
        if v >= x:
            high = mid - 1
        else:
            low = mid + 1

    return low


# print(bs([8, 11, 19, 23, 27, 33, 45, 55, 67, 98], 19) == 2)
# print(bs([8, 11, 19, 23, 27, 33, 45, 55, 67, 98], 33) == 5)
# print(bs([8, 11, 19, 23, 27, 33, 45, 55, 67, 98], 18) == -1)
# print(bs([8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 19) == 4)
#
# print(bs_first([8, 8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 11) == 3)
# print(bs_first([8, 8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 8) == 0)
# print(bs_first([8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 18) == -1)
# print(bs_first([8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 188) == -1)
# print(bs_first([8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 1) == -1)

print(bs_last([8, 8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 11) == 4)
print(bs_last([8, 8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 8) == 2)
print(bs_last([8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 18) == -1)
print(bs_last([8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 188) == -1)
print(bs_last([8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 1) == -1)

# print(bs_gte([8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 17) == 4)
# print(bs_gte([8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 19) == 4)
# print(bs_gte([8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 100) == 12)
# print(bs_gte([8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 8) == 0)
# print(bs_gte([8, 8, 11, 11, 19, 23, 27, 33, 45, 55, 67, 98], 7) == 0)
