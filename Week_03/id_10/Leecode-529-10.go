package leecode

func updateBoard(board [][]byte, click []int) [][]byte {
	if board[click[0]][click[1]] == 'M' {
		board[click[0]][click[1]] = 'X'
	} else if board[click[0]][click[1]] == 'E' {
		helper(board, click)
	}
	return board
}

func helper(board [][]byte, pos []int) {
	x, y := pos[0], pos[1]
	minescount := byte(0)
	if board[x][y] != 'E' {
		return
	}
	alldots := make([][]int, 8)
	alldots[0] = []int{x - 1, y - 1}
	alldots[1] = []int{x, y - 1}
	alldots[2] = []int{x + 1, y - 1}
	alldots[3] = []int{x - 1, y}
	alldots[4] = []int{x - 1, y + 1}
	alldots[5] = []int{x, y + 1}
	alldots[6] = []int{x + 1, y + 1}
	alldots[7] = []int{x + 1, y}
	nextposes := make([][]int, 0, 8)
	for i := 0; i < 8; i++ {
		posx, posy := alldots[i][0], alldots[i][1]
		if posx >= 0 && posy >= 0 && posx < len(board) && posy < len(board[0]) {
			if board[posx][posy] == 'M' {
				minescount++
			} else if board[posx][posy] == 'E' {
				nextposes = append(nextposes, []int{posx, posy})
			}
		}
	}
	if minescount > 0 {
		board[x][y] = '0' + minescount
	} else {
		board[x][y] = 'B'
		for _, npos := range nextposes {
			helper(board, npos)
		}
	}

}
