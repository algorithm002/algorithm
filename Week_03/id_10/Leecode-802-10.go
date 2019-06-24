package leecode

var safenodes []int
var curgraph [][]int
var visited []bool

func eventualSafeNodes(graph [][]int) []int {
	n := len(graph)
	safenodes = make([]int, n)
	curgraph = graph
	results := make([]int, 0)
	visited = make([]bool, n)
	for i := 0; i < n; i++ {
		if isSafeNode(i) {
			results = append(results, i)
		}
	}
	return results
}

func isSafeNode(i int) bool {
	if safenodes[i] == 1 {
		return true
	} else if safenodes[i] == -1 {
		return false
	}
	graph := curgraph
	visited[i] = true
	for j := 0; j < len(graph[i]); j++ {
		node := graph[i][j]
		if safenodes[node] == 1 {
			continue
		}
		if visited[node] || !isSafeNode(node) {
			safenodes[i] = -1
			return false
		}
	}
	safenodes[i] = 1
	return true
}
