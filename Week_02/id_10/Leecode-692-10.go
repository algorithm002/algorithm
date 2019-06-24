import "sort"

type WNode struct {
	Val      string
	Frequent int
}

type WNodes []*WNode

func (s WNodes) Len() int      { return len(s) }
func (s WNodes) Swap(i, j int) { s[i], s[j] = s[j], s[i] }
func (s WNodes) Less(i, j int) bool {
	if s[i].Frequent > s[j].Frequent {
		return true
	} else if s[i].Frequent == s[j].Frequent {
		return s[i].Val < s[j].Val
	}
	return false
}

func topKFrequent(words []string, k int) []string {
	if k <= 0 {
		return []string{}
	}
	frequenthash := make(map[string]*WNode)
	frequentarr := make([]*WNode, 0, len(words))
	for i := 0; i < len(words); i++ {
		w := words[i]
		if node, ok := frequenthash[w]; ok {
			node.Frequent++
		} else {
			node = &WNode{w, 1}
			frequenthash[w] = node
			frequentarr = append(frequentarr, node)
		}
	}
	sort.Sort(WNodes(frequentarr))
	retarr := make([]string, k)
	for i := 0; i < k; i++ {
		retarr[i] = frequentarr[i].Val
	}
	return retarr

}
