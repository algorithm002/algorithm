/**
 * @param {character[][]} board
 * @param {number[]} click
 * @return {character[][]}
 * https://leetcode.com/problems/minesweeper/
 */
var updateBoard = function(board, click) {
    let m = board.length, n = board[0].length;
    let direction = [[0, 1], [1, 0], [0, -1], [-1, 0], [1, 1], [-1, -1], [1, -1], [-1, 1]];
    
    let cX = click[0];
    let cY = click[1];
    if (board[cX][cY] == 'M') {
        board[cX][cY] = 'X';
    }
    if (board[cX][cY] == 'E') {
        let count = 0;
        for (let i = 0; i < direction.length; i++) {
            let x = cX + direction[i][0], y = cY + direction[i][1];
            if (x >= 0 && y >= 0 && x < m && y < n && board[x][y] == 'M') {
                count++;
            }
        }
        if (count == 0) {
          board[cX][cY] = 'B';
          for (let i = 0; i < direction.length; i++) {
              let x = cX + direction[i][0], y = cY + direction[i][1];
              if (x >= 0 && y >= 0 && x < m && y < n) {
                  updateBoard(board, [x, y]);
              }
          }
        } else {
          board[cX][cY] = count.toString();
        }
    }
    return board;
};