# 题目未要求原地排序 所以弄个简单的


def merge(nums1, m, nums2, n):
    r = nums1[:m] + nums2[:n]
    r.sort()
    nums1[:m+n] = r
