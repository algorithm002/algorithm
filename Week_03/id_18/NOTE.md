# 学习笔记
## LeetCode_200
### 题目

### 解法一
#### 思路
使用dfs的思路，从当前方块的上下左右递归的执行逻辑。
1. 对二维数组进行遍历，只要发现是1，就开始执行逻辑，同时计数+1
2. 逻辑内容是：
  - 从这个为1的方块开始，对它的上下左右递归检查
  - 递归下钻中只要发现仍然是1的，就把这个为1的方块设置为0，这样在最外层遍历的时候，就不会重复的进到这里执行逻辑了，也可以理解成已经检查过
  - 如果行列的坐标超出了二维数组的边界，或者遇到的是0的时候，就返回
3. 在二维数组遍历结束以后，就返回计数值即可

这个解法是从国际站上看来的，也记得覃老师也在课上讲过，思路非常巧妙，代码也非常简洁。真的很赞。
#### 代码
```java
class Solution {
    private int rowNum;
    private int colNum;
    
    public int numIslands(char[][] grid) {
        int count = 0;
        rowNum = grid.length;
        if (rowNum == 0) {
            return 0;
        }
        colNum = grid[0].length;
        
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if (grid[row][col] == '1') {
                    drown(grid, row, col);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void drown(char[][] grid, int row, int col) {
        if (row < 0 || row >= rowNum || col < 0 || col>= colNum || grid[row][col] != '1') {
            return;
        }
        
        grid[row][col] = '0';
        drown(grid, row + 1, col);
        drown(grid, row, col + 1);
        drown(grid, row - 1, col);
        drown(grid, row, col - 1);
    }
}
```
### 收获
