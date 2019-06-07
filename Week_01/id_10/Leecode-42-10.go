func trap(height []int) int {
	totals := 0
	startpos := 0
	for i := 1; i < len(height); i++ {
		curh := height[i]
		if curh >= height[startpos] {
			minh := height[startpos]
			curw := i - startpos - 1
			if curw == 0 {
				startpos = i
				continue
			}
			rangenums := minh * curw
			for j := startpos + 1; j < i; j++ {
				rangenums -= height[j]
			}
			totals += rangenums
			startpos = i
		}
	}
	biggestpos := startpos
	startpos = len(height) - 1
	for i := len(height) - 2; i >= biggestpos; i-- {
		curh := height[i]
		if curh >= height[startpos] {
			minh := height[startpos]
			curw := startpos - i - 1
			if curw == 0 {
				startpos = i
				continue
			}
			rangenums := minh * curw
			for j := i + 1; j < startpos; j++ {
				rangenums -= height[j]
			}
			totals += rangenums
			startpos = i
		}
	}
	return totals
}
