package leecode

func findOrder(numCourses int, prerequisites [][]int) []int {
	// 拓扑排序  BFS
	courserel := make([][]int, numCourses)
	indegree := make([]int, numCourses)
	for _, prereq := range prerequisites {
		if courserel[prereq[1]] == nil || len(courserel[prereq[1]]) == 0 {
			courserel[prereq[1]] = []int{prereq[0]}
		} else {
			courserel[prereq[1]] = append(courserel[prereq[1]], prereq[0])
		}
		indegree[prereq[0]]++
	}
	queen := make([]int, 0)
	for i, degree := range indegree {
		if degree == 0 {
			queen = append(queen, i)
		}
	}
	result := make([]int, 0)
	for len(queen) > 0 {
		top := queen[0]
		queen = queen[1:len(queen)]
		result = append(result, top)
		if courserel[top] != nil && len(courserel[top]) > 0 {
			for _, c := range courserel[top] {
				indegree[c]--
				if indegree[c] == 0 {
					queen = append(queen, c)
				}
			}
		}
	}
	if len(result) != numCourses {
		return []int{}
	}
	return result
}

func findOrder2(numCourses int, prerequisites [][]int) []int {
	// DFS
	courserels := make([][]int, numCourses)
	for _, prereq := range prerequisites {
		if courserels[prereq[0]] == nil {
			courserels[prereq[0]] = []int{prereq[1]}
		} else {
			courserels[prereq[0]] = append(courserels[prereq[0]], prereq[1])
		}
	}
	visited := make([]int, numCourses)
	result := make([]int, 0)
	var dfs func(course int) bool
	dfs = func(course int) bool {
		if visited[course] == 1 {
			return false
		}
		if visited[course] == 2 {
			return true
		}
		visited[course] = 1
		if courserels[course] == nil || len(courserels[course]) == 0 {
			result = append(result, course)
			visited[course] = 2
			return true
		}
		for _, next_course := range courserels[course] {
			if !dfs(next_course) {
				return false
			}
		}
		result = append(result, course)
		visited[course] = 2
		return true
	}
	for i := 0; i < numCourses; i++ {
		if !dfs(i) {
			return []int{}
		}
	}
	return result

}
