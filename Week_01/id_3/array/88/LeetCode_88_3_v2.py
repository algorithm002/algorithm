# 题目并未要求原地排序 所以弄个简单的


def merge(nums1, m, nums2, n):
    nums1[:m+n] = sorted(nums1[:m] + nums2[:n])
