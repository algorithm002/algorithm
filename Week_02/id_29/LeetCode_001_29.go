package leetcode

func twoSum(nums []int, target int) []int {
	// m store value and index
	visited := make(map[int]int)

	for currentIndex, v := range nums {
		// 找對應的元素
		counterPart := target - v

		counterPartIndex, ok := visited[counterPart]
		if ok {
			// 在 map 找到直接回傳
			return []int{counterPartIndex, currentIndex}
		}
		// 找不到就把自己加入到 map 裡面
		visited[v] = currentIndex
	}

	return []int{-1, -1}
}
