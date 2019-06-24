package main

func findOrder(numCourses int, prerequisites [][]int) []int {

	queue := make([]int, 0, numCourses)
	inDegree := make([]int, numCourses, numCourses)
	graph := make(map[int][]int)

	for _, edge := range prerequisites {
		from, to := edge[1], edge[0]
		inDegree[to]++
		graph[from] = append(graph[from], to)
	}

	for i, n := range inDegree {
		if n == 0 {
			queue = append(queue, i)
		}
	}

	for i := 0; i < numCourses; i++ {
		if i >= len(queue) {
			return []int{}
		}
		course := queue[i]
		nextCourses := graph[course]

		for _, next := range nextCourses {
			inDegree[next]--
			if inDegree[next] == 0 {
				queue = append(queue, next)
			}
		}
	}

	return queue
}
