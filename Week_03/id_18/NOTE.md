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
这个解法是从国际站上看来的，也记得覃老师也在课上讲过，思路非常巧妙，代码也非常简洁。真的很赞。
## LeetCode_703
### 题目
设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。

你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。

示例:
```
int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
说明: 
你可以假设 nums 的长度≥ k-1 且k ≥ 1。
```
### 失败的解法
#### 思路
1. 将数组排序，截取最大的k个
2. 每次add的时候都和第一个元素比较，如果比它大，就先替换
3. 然后对数组重新排序
4. 返回数组的第一个元素

这种计算的结果是超出限制时间，看了leetcode的测试用例，k非常大，因为我每次都要在add的时候对数组进行排序，所以非常耗时。
#### 代码
```java
class KthLargest {
    int[] nums;
    int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        Arrays.sort(nums);
        this.nums = nums.length < k ? nums : Arrays.copyOfRange(nums, nums.length - k, nums.length);
    }
    
    public int add(int val) {
        if (nums.length < k) {
            nums = Arrays.copyOf(nums, nums.length + 1);
            nums[nums.length - 1] = val;
        } else if (nums[0] < val){
            nums[0] = val;
        }
        
        Arrays.sort(nums);
        return nums[0];
    }
}
```
### 解法一
#### 思路
使用优先级队列，使用升序排序
1. 因为是升序队列，队列顶部会是入队元素中最小的一个
2. 在队列不足k个元素的时候随意入队
3. 当队列个数等于k个后，队顶的那个元素就可以和之后入队的元素进行比较，比队大的就进行替换，一直保持队列中保持所有元素最大的k个
4. 结果就直接返回队顶元素
#### 代码
```java
class KthLargest {
    private Queue<Integer> queue;
    private int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);
        for (int num: nums) {
            offer(num);
        }
    }
    
    public int add(int val) {
        offer(val);
        return this.queue.peek();
    }
    
    private void offer(int num) {
        if (this.queue.size() < this.k) {
            this.queue.offer(num);
        } else if (this.queue.peek() > num) {
            this.queue.poll();
            this.queue.offer(num);
        }
    }
}
```
### 收获
学习到了PriorityQueue的用法，平常不太使用。