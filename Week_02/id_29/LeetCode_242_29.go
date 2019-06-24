package leetcode

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	mapA := buildCharMap(s)
	mapB := buildCharMap(t)

	for key, Acount := range mapA {
		Bcount, ok := mapB[key]
		if !ok {
			return false
		}
		if Acount != Bcount {
			return false
		}
	}

	return true
}

func buildCharMap(s string) map[rune]int {
	m := make(map[rune]int)

	for _, char := range s {
		if _, ok := m[char]; ok {
			m[char]++
		} else {
			m[char] = 1
		}
	}

	return m
}
