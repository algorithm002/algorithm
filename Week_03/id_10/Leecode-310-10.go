package leecode

func findMinHeightTrees(n int, edges [][]int) []int {
	if n == 0 {
		return []int{}
	}
	if n == 1 {
		return []int{0}
	}

	graphs := make([][]int, n)
	count := make([]int, n)
	for i := 0; i < len(edges); i++ {
		graphs[edges[i][0]] = append(graphs[edges[i][0]], edges[i][1])
		graphs[edges[i][1]] = append(graphs[edges[i][1]], edges[i][0])
		count[edges[i][1]]++
		count[edges[i][0]]++
	}
	leaves := []int{}
	for i := 0; i < len(count); i++ {
		if count[i] == 1 {
			leaves = append(leaves, i)
			count[i] = 0
		}
	}
	for len(leaves) > 0 {
		newleaves := []int{}
		for j := 0; j < len(leaves); j++ {
			nextlevels := graphs[leaves[j]]
			for i := 0; i < len(nextlevels); i++ {
				leaf := nextlevels[i]
				if count[leaf] > 0 {
					count[leaf]--
					if count[leaf] == 1 {
						newleaves = append(newleaves, leaf)
						count[leaf] = 0
					}
				}
			}
		}
		if len(newleaves) == 0 {
			return leaves
		}
		leaves = newleaves
	}

	return []int{}
}
