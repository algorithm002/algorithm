func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	// 如果字符串包含 unicode 字符，使用map处理
	// 测试数据："中国" ,"国中"
	anagramrel := make(map[rune]int)
	for _, b := range s {
		anagramrel[b]++
	}
	for _, b := range t {
		anagramrel[b]--
		if anagramrel[b] < 0 {
			return false
		}
	}
	return true
}

func isAnagram2(s string, t string) bool {
	sbytes := []byte(s)
	tbytes := []byte(t)
	if len(sbytes) != len(tbytes) {
		return false
	}
	// 如果字符串只包含小写字母  创建len=26的数组代替map
	hasharr := make([]int, 26)
	for i := 0; i < len(sbytes); i++ {
		sb := sbytes[i]
		hasharr[sb-'a'] += 1
	}
	for i := 0; i < len(tbytes); i++ {
		tb := tbytes[i]
		hasharr[tb-'a'] -= 1
		if hasharr[tb-'a'] < 0 {
			return false
		}
	}
	return true
}
