class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums) == 0 or len(nums) == 1:
            return
        l = len(nums)
        if k > l:
            k = k % l

        endindex = len(nums)
        startindex = k
        while k > 0:
            while startindex + k < endindex:
                for i in range(k):
                    tmp = nums[startindex + i]
                    nums[startindex + i] = nums[i]
                    nums[i] = tmp
                startindex = startindex + k
            if startindex < endindex:
                leftednum = endindex - startindex
                for i in range(leftednum):
                    tmp = nums[startindex + i]
                    nums[startindex + i] = nums[i]
                    nums[i] = tmp
            else:
                break
            endindex = k
            k = k - leftednum
            startindex = k

    def rotate3(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums) == 0 or len(nums) == 1:
            return
        l = len(nums)
        if k > l:
            k = k % l

        newarr = nums[len(nums) - k:]
        for i in range(len(nums) - k - 1, -1, -1):
            nums[i + k] = nums[i]
        for i in range(k):
            nums[i] = newarr[i]

    def rotate2(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums) == 0 or len(nums) == 1:
            return
        l = len(nums)
        if k > l:
            k = k % l

        for _ in range(k):
            lastel = nums[l - 1]
            for i in range(l - 2, -1, -1):
                nums[i + 1] = nums[i]
            nums[0] = lastel