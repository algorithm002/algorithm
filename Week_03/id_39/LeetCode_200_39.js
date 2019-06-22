/**
 * @param {character[][]} grid
 * @return {number}
 * https://leetcode.com/problems/number-of-islands/
 */

/**
 * 以下为 dfs递归染色解法
 */
var dfs = function (grid, i, j) {
    let direction = [[1, 0], [-1, 0], [0, 1], [0, -1]];
    grid[i][j] = '0'; 
    for (let h = 0; h < direction.length; h++) {
        let x = direction[h][0];
        let y = direction[h][1];
        if (grid[i+x] && grid[i+x][j+y] == '1') {
            grid[i+x][j+y] = '0';
            dfs(grid, i+x, j+y);
        }
    }
}
 
var numIslands = function(grid) {
    let count = 0;
    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[i].length; j++) {
            if (grid[i][j] == '1') {
                count++;
                dfs(grid, i, j);
            }
        }
    }
    return count;
};


/**
 * 以下为用并查集的解法
 */
class UnionFind{
    constructor(grid) {
        let m = grid.length, n = grid[0].length;
        this.count = 0;
        this.parent = new Array(m*n).fill(-1);
        this.rank = new Array(m*n).fill(0);
        for (let i = 0; i < m; i++) {
            for (let j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    this.parent[i * n + j] = i * n + j;
                    this.count++;
                }  
            }
        }
    }
    find(i) {
        if (this.parent[i] != i) {
            this.parent[i] = this.find(this.parent[i]);
        }
        return this.parent[i];
    }
    union(x, y) {
        let rootx = this.find(x);
        let rooty = this.find(y);
        if (rootx != rooty) {
            if (this.rank[rootx] > this.rank[rooty]) {
                this.parent[rooty] = rootx;
            } else if (this.rank[rootx] < this.rank[rooty]) {
                this.parent[rootx] = rooty;
            } else {
                this.parent[rooty] = rootx;
                this.rank[rootx] += 1;
            }
            this.count--;
        }
    }
}

var numIslands = function(grid) {
    if (!grid || !grid[0]) {
        return 0;
    }
    let uf = new UnionFind(grid);
    let direction = [[1, 0], [-1, 0], [0, 1], [0, -1]];
    let m = grid.length, n = grid[0].length;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] == '0') {
                continue;
            }
            for (let d = 0; d < direction.length; d++) {
                let nr = i + direction[d][0], nc = j + direction[d][1];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                    uf.union(i * n + j, nr * n + nc);
                }
            }
        }
    }
    
    return uf.count;
};