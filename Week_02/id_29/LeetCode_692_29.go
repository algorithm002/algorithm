package leetcode

import "sort"

type entry struct {
	word      string
	frequence int
}

type freWords []*entry

func topKFrequent(words []string, k int) []string {
	count := make(map[string]int, len(words))
	for _, w := range words {
		count[w]++
	}

	fw := make(freWords, 0, len(count))
	for w, c := range count {
		fw = append(fw, &entry{
			word:      w,
			frequence: c,
		})
	}

	sort.Slice(fw, func(i, j int) bool {
		if fw[i].frequence == fw[j].frequence {
			return fw[i].word < fw[j].word
		}
		return fw[i].frequence > fw[j].frequence
	})

	res := make([]string, k)
	for i := 0; i < k; i++ {
		res[i] = fw[i].word
	}

	return res
}
