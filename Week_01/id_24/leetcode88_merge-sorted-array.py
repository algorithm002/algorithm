def merge(nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """

        # s1
        # i = 0
        # j = 0
        # ls = []
        # while i + j < m + n:
        #     if i == m or nums1[i] > nums2[j]:
        #         ls.append(nums2[j])
        #         j = j + 1
        #     elif j == n or nums1[i] < nums2[j]:
        #         ls.append(nums1[i])
        #         i = i + 1
        #     elif nums1[i] == nums2[j]:
        #         ls.append(nums1[i])
        #         ls.append(nums2[j])
        #         i = i + 1
        #         j = j + 1

        # nums1 = ls
        # print(nums1)

        # s2
        if n == 0: return False
        index = m + n - 1
        while index >= 0:
            if n == 0 or (m != 0 and nums1[m - 1] > nums2[n - 1]):
                nums1[index] = nums1[m - 1]
                if m > 0: m = m - 1
            elif m == 0 or (n != 0 and nums1[m - 1] < nums2[n - 1]):
                nums1[index] = nums2[n - 1]
                if n > 0: n = n - 1
            else:
                nums1[index] = nums1[m - 1]
                nums1[index - 1] = nums2[n - 1]
                index = index - 1
                if m > 0: m = m - 1
                if n > 0: n = n - 1
            index = index - 1

merge(
    [2,0],
    1,
    [1],
    1
)