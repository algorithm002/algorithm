# nums1 m -> m+n 位置是剩余空间 如果按从小到大排序会出现复杂的冲突
# 而从大到小排列， 最大的元素移动到剩余空间的末端，则可以避免出现冲突


def merge(nums1, m, nums2, n):
    tail = m + n
    for i in range(tail):
        tail -= 1
        if n < 0:
            break
        if m >= 0 and nums1[m] > nums2[n]:
            m -= 1
            nums1[tail] = nums1[m]
        else:
            n -= 1
            nums1[tail] = nums2[n]
