package leecode

func searchMatrix(matrix [][]int, target int) bool {
	//题解
	m := len(matrix)
	if m == 0 {
		return false
	}
	n := len(matrix[0])
	if n == 0 {
		return false
	}
	i := 0
	j := n - 1
	for i < m && j >= 0 {
		if matrix[i][j] == target {
			return true
		} else if matrix[i][j] < target {
			i++
		} else {
			j--
		}
	}
	return false
}

func searchMatrix2(matrix [][]int, target int) bool {
	//分治法
	m := len(matrix)
	if m == 0 {
		return false
	}
	n := len(matrix[0])
	if n == 0 {
		return false
	}
	pos1 := []int{0, 0}
	pos2 := []int{m - 1, n - 1}
	return helper(matrix, pos1, pos2, target)
}

func binary_search_hen(matrix [][]int, target int, x, y1, y2 int) bool {
	// 横向二分查找
	if x >= len(matrix) {
		return false
	}
	l := y1
	r := y2
	for l <= r {
		mid := (l + r) / 2
		if matrix[x][mid] == target {
			return true
		} else if matrix[x][mid] < target {
			l = mid + 1
		} else {
			r = mid - 1
		}
	}
	return false
}

func binary_search_shu(matrix [][]int, target int, y, x1, x2 int) bool {
	// 竖向二分查找
	if y >= len(matrix[0]) {
		return false
	}
	l := x1
	r := x2
	for l <= r {
		mid := (l + r) / 2
		if matrix[mid][y] == target {
			return true
		} else if matrix[mid][y] < target {
			l = mid + 1
		} else {
			r = mid - 1
		}
	}
	return false
}

func helper(matrix [][]int, pos1, pos2 []int, target int) bool {
	if pos1[0] < 0 || pos1[1] < 0 || pos2[0] < pos1[0] || pos2[1] < pos1[1] {
		return false
	}
	if pos1[0] == pos2[0] && pos1[1] == pos2[1] {
		return matrix[pos1[0]][pos1[1]] == target
	}
	if pos1[0] == pos2[0] {
		return binary_search_hen(matrix, target, pos1[0], pos1[1], pos2[1])
	}
	if pos1[1] == pos2[1] {
		return binary_search_shu(matrix, target, pos1[1], pos1[0], pos2[0])
	}
	midx := (pos1[0] + pos2[0]) / 2
	midy := (pos1[1] + pos2[1]) / 2
	if matrix[midx][midy] == target {
		return true
	}
	if matrix[midx][midy] < target {
		ret := binary_search_hen(matrix, target, midx, midy+1, pos2[1])
		if ret {
			return true
		}
		ret = binary_search_shu(matrix, target, midy, midx+1, pos2[0])
		if ret {
			return true
		}
		ret = helper(matrix, []int{midx + 1, midy + 1}, pos2, target)
		if ret {
			return true
		}
	} else {
		ret := binary_search_hen(matrix, target, midx, pos1[1], midy-1)
		if ret {
			return true
		}
		ret = binary_search_shu(matrix, target, midy, pos1[0], midx-1)
		if ret {
			return true
		}
		ret = helper(matrix, pos1, []int{midx - 1, midy - 1}, target)
		if ret {
			return true
		}
	}
	ret := helper(matrix, []int{midx + 1, pos1[1]}, []int{pos2[0], midy - 1}, target)
	if ret {
		return true
	}
	ret = helper(matrix, []int{pos1[0], midy + 1}, []int{midx - 1, pos2[1]}, target)
	if ret {
		return true
	}
	return false
}
