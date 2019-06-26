package leecode

func majorityElement(nums []int) int {
	//分治法
	return helper(nums, 0, len(nums)-1)
}

func helper(nums []int, low, high int) int {
	if low == high {
		return nums[low]
	}
	mid := (low + high) / 2
	left := helper(nums, low, mid)
	right := helper(nums, mid+1, high)
	if left == right {
		return left
	}
	leftCount := 0
	rightCount := 0
	for i := low; i <= high; i++ {
		if nums[i] == left {
			leftCount++
		} else if nums[i] == right {
			rightCount++
		}
	}
	if leftCount >= rightCount {
		return left
	}
	return right
}

func majorityElement3(nums []int) int {
	// 题解  Boyer-Moore 投票算法
	count := 1
	num := nums[0]
	for i := 1; i < len(nums); i++ {
		if count == 0 {
			num = nums[i]
			count = 1
		} else if num == nums[i] {
			count++
		} else {
			count--
		}
	}
	return num
}

func majorityElement2(nums []int) int {
	//使用 map 记录个数
	numMap := make(map[int]int)
	numLen := len(nums)
	for i := 0; i < numLen; i++ {
		num := nums[i]
		numMap[num]++
		if numMap[num] > numLen/2 {
			return num
		}
	}
	return -1
}
