func lengthOfLongestSubstring(s string) int {
	if len(s) == 0 {
		return 0
	}
	maxsublen := 1
	lastlen := 1
	alphaposrel := make(map[byte]int)
	alphaposrel[s[0]] = 0
	for i := 1; i < len(s); i++ {
		b := s[i]
		cursublen := 0
		if pos, ok := alphaposrel[b]; ok {
			cursublen = i - pos
		} else {
			cursublen = i + 1
		}
		if cursublen > lastlen+1 {
			cursublen = lastlen + 1
		}
		if maxsublen < cursublen {
			maxsublen = cursublen
		}
		lastlen = cursublen
		alphaposrel[b] = i
	}
	return maxsublen
}