import lc_88_v1
import lc_88_v2

f = lc_88_v1.merge
# f = lc_88_v2.merge


def check(nums1, m, nums2, n, r):
    f(nums1, m, nums2, n)
    print(nums1, nums1 == r)


check([1, 2, 3, 0, 0, 0], 3, [2, 5, 6], 3, [1, 2, 2, 3, 5, 6])
