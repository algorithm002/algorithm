package leecode

func subsets(nums []int) [][]int {
	results := make([][]int, 0)
	var helper func(nums []int, start int, result []int)
	helper = func(nums []int, start int, result []int) {
		if start >= len(nums) {
			copyresult := make([]int, len(result))
			copy(copyresult, result)
			results = append(results, copyresult)
			return
		}
		// 每个数字两种选择 取 不取
		helper(nums, start+1, result)
		result = append(result, nums[start])
		helper(nums, start+1, result)
		result = result[0 : len(result)-1]
	}
	result := make([]int, 0)
	helper(nums, 0, result)
	return results
}
