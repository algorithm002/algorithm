# 学习笔记
## LeetCode_200
### 题目
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:
```
输入:
11110
11010
11000
00000

输出: 1
```
示例 2:
```
输入:
11000
11000
00100
00011

输出: 3
```
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
## LeetCode_104
### 题目
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
```
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
```
### 解法一
#### 思路
dfs非递归
1. 两个stack分别存当前下钻的那个节点node，及下钻时的深度count，还有一个max变量存最大值
2. 遍历nodeStack的时候，将node和count分别出栈，计算count和max的最大值
3. 上面一步干完后，开始准备下钻，分别走左右两边，判断是否为空
4. 不为空就把对应一边的节点入栈，同时count+1以后也入栈，开始下一步
5. 最后返回max
#### 代码
```java
class Solution {
    private Stack<TreeNode> nodeStack = new Stack<>();
    private Stack<Integer> countStack = new Stack<>();
    
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        nodeStack.push(root);
        countStack.push(1);
        int max = 0;

        while (!nodeStack.empty()) {
            TreeNode node = nodeStack.pop();
            int count = countStack.pop();
            max = Math.max(max, count);

            drillDownAndCount(node.left, count);
            drillDownAndCount(node.right, count);
        }

        return max;
    }

    private void drillDownAndCount(TreeNode node, int count) {
        if (node != null) {
            nodeStack.push(node);
            countStack.push(count + 1);
        }
    }
}
```
### 解法二
#### 思路
dfs递归，和解法一思路差不多，但是代码简单不少
1. 建一个函数，用来递归，有两个参数分别是上一层层数和当前层节点
2. 如果节点为空，就把上一层的层数返回
3. 否则就在层数上+1，标记这一层探索过，然后继续下钻
4. 返回的时候是比左右节点的大小，取大的值
#### 代码
```java
public class Solution {
    public int maxDepth(TreeNode root) {
        return doSearch(0, root);
    }

    private int doSearch(int level, TreeNode root) {
        if (root == null) {
            return level;
        }

        level++;

        return Math.max(doSearch(level, root.left), doSearch(level, root.right));
    }
}
```
### 解法三
#### 思路
使用bfs，思路和解法一、二略有不同，因为是广度优先搜索，所以不需要取比较左右子树节点返回的深度最大值，只需要一层层的扫就可以了。
1. 一个队列存放当前层的节点
2. 遍历队列，获得当前层节点的个数
3. 然后分别再去判断这些节点是否有子节点，把那些子节点放入队列，作为下一层需要判断的节点。
4. 同时在当前层对count值+1，计数
5. 循环往复，最终返回count
#### 代码
```java
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        int count = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int nodeNum = queue.size();
            while (nodeNum-- > 0) {
                 TreeNode node = queue.poll();
                 if (node.left != null) {
                     queue.offer(node.left);
                 }

                 if (node.right != null) {
                     queue.offer(node.right);
                 }
            }
            count++;
        }

        return count;
    }
}
```
### 收获
进一步熟练了dfs的2种解法，bfs的1种解法。
## LeetCode_111
### 题目
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:
```
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.
```
### 解法一
#### 思路
和104题的思路是一样的，使用dfs的非递归方法，递归方法在第2周的时候写过
1. 把root为空，root左右子树为空的情况先去掉
2. 用nodeStack栈来保存dfs深度搜索使用的节点，维护顺序
3. 用countStack栈来保存层数，维护顺序，和nodeStack顺序一致就可以
4. 每次循环都把两个栈的第一个元素弹出，因为顺序一致，这两个出栈元素其实就代表了探索到的这个node和它所在的层数
5. 当左右子树不为空的时候，分别把左右子树压入nodeStack栈，同时把count+1分别压入countStack栈
6. 当nodeStack出栈的这个节点的左右子树都为空的时候，把count和min作比较，取小的那个
7. 循环往复，最后返回min作为结果
#### 代码
```java
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        
        nodeStack.push(root);
        countStack.push(1);
        
        int min = Integer.MAX_VALUE;
        
        while (!nodeStack.empty()) {
            TreeNode node = nodeStack.pop();
            int count = countStack.pop();
            
            if (node.left == null && node.right == null) {
                min = Math.min(count, min);
            } 
            
            if (node.left != null) {
                nodeStack.push(node.left);
                countStack.push(count + 1);
            } 
            
            if (node.right != null) {
                nodeStack.push(node.right);
                countStack.push(count + 1);
            }
        }
        
        return min;
    }
}
```
### 解法二
#### 思路
使用bfs来解这个题，遇到的第一个叶子节点，就把count返回，过程和104题的bfs解法类似，只不过不用走到最后
#### 代码
```java
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        int count = 0;
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int nodeSize = queue.size();
            count++;
            while (nodeSize-- > 0) {
                TreeNode node = queue.poll();
                if (node.right == null && node.left == null) {
                    return count;
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        return count;
    }
}
```
### 收获
再一次的熟悉了dfs和bfs，做类似题有点快了。
## LeetCode_429
### 题目
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

例如，给定一个3叉树，返回其层序遍历:
```
[
     [1],
     [3,2,4],
     [5,6]
]
```

说明:
```
树的深度不会超过 1000。
树的节点总数不会超过 5000。
```
### 解法一
#### 思路
使用bfs来解决这道题
1. 使用队列，开始bfs
2. 每一层干两件事：
  - 遍历当前层节点，并往队列里入下一层的节点
  - 把当前层的val放入当前层的list，再在当前层节点遍历完以后，放入整个结果的list
3. 循环结束，返回result
#### 代码
```java
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> levelNodeVals = new ArrayList<>(count);
            while (count-- > 0) {
                Node node = queue.poll();
                levelNodeVals.add(node.val);
                for (Node childNode: node.children) {
                    queue.offer(childNode);
                }
            }
            
            result.add(levelNodeVals);
        }
        
        return result;    
    }
}
```
### 收获
又对bfs有了进一步的练习加深
## LeetCode_210
### 题目
现在你总共有 n 门课需要选，记为 0 到 n-1。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。

可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。

示例 1:
```
输入: 2, [[1,0]] 
输出: [0,1]
解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
```
示例 2:
```
输入: 4, [[1,0],[2,0],[3,1],[3,2]]
输出: [0,1,2,3] or [0,2,1,3]
解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
```
说明:
```
输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
```
### 解法一
#### 思路
1. 使用bfs的方式。首先需要确定第一层节点
2. 使用一个map，维护课程关系,**后修课程的节点**和**需要先修的课程节点们**的映射关系
3. 在维护map的同时，也要维护一个**课程**和**需要先修课程数**的映射关系，因为这种要很多先修课程的课肯定是最后几个才能修的课，维护的课程数作为是否已学了先修课程的统计变量进行递减，直到为0，意味着已经可以直接修这门课了
4. 把那个先修课程数为0的课程全部入队，这些就是**第一层的节点，那些不需要先修课程的课程**，开始进行bfs的while循环
5. 在while语句种按老规矩出队第一层节点，把他们依次记录在result数组里
6. 使用循环里出队的节点查询map种的下一层节点，把这些节点的先修课程数-1，因为当前课程在这次循环中相当于学完了
7. 判断先修课程数是否为0，如果是，就可以入队，在下个循环中出队(**被学习**)，同时也放到result数组里
8. 最后判断result数组放满了没有，如果没有，就说明课程安排没法全部学完，否则就返回这个result
#### 代码
```java
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] record = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] arr: prerequisites) {
            int des = arr[0];
            int src = arr[1];
            map.computeIfAbsent(src, k -> new ArrayList<>());
            map.get(src).add(des);

            record[des]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < record.length; i++) {
            if (record[i] == 0) {
                queue.offer(i);
            }
        }

        int i = 0;
        while (!queue.isEmpty()) {
            Integer lesson = queue.poll();
            result[i++] = lesson;
            if (map.get(lesson) != null) {
                for (Integer desLesson: map.get(lesson)) {
                    if (--record[desLesson] == 0) {
                        queue.offer(desLesson);
                    }
                }
            }
        }

        return i == numCourses ? result: new int[0];
    }
}
```
### 收获
这题上来看第一遍，是懵的
1. 开始找脑中有没有对应的解法，或以前类似做过的，没有
2. 然后开始自己想办法解，只有一点模糊的概念
3. 在看了国际站的sol以后才有了具体的思路

但发现这个过程其实对我自己有很大的帮助，想过以后再看别人的解法，尤其是和自己脑中的大概思路类似的解法，理解起来就非常快，记忆也更深刻。
## LeetCode_295
### 题目
中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：
```
void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
```
示例：
```
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
```
### 解法一
#### 思路
参考国内站的解法，使用两个堆来解决，反别是大顶堆和小顶堆
1. 对两个堆设定2个前提：
  - 大顶堆的堆顶元素永远小于或等于小顶堆的堆顶元素
  - 大顶堆的元素个数：
    - 在总个数为奇数的时候比小顶堆多1个
    - 在总个数为偶数的时候和小顶堆一样
2. 先将元素放入大顶堆排序，获得大顶堆中的最大值
3. 再将这个最大值放入小顶堆中，获得小顶堆的最小值
4. 如果这个时候总个数是奇数，就把小顶堆的那个堆顶元素还给大顶堆
5. 通过以上3步就可以使得计算只围绕两个堆顶元素来进行
  - 奇数的时候，大顶堆的那个最大值就是中位数
  - 偶数的时候，两个堆的堆顶元素平均值就是中位数
#### 代码
```java
class MedianFinder {
    private int count;
    private Queue<Integer> maxHeap;
    private Queue<Integer> minHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count++;
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if ((count & 1) == 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        return (count & 1) == 0 ? (new Double(maxHeap.peek()) + new Double(minHeap.peek())) / 2 : maxHeap.peek();
    }
}
```
### 失败解法
#### 思路
每次都进行排序，然后返回中位数，暴力简单。但是耗时超出了测试要求。
#### 代码
```java
class MedianFinder {
    private List<Integer> list;
    
    public MedianFinder() {
        list = new ArrayList();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        Collections.sort(list);
        int midNum = list.size() / 2;
        return (list.size() & 1) == 0 ? (new Double(list.get(midNum - 1)) + new Double(list.get(midNum))) / 2 : list.get(midNum);
    }
}
```
### 解法二
#### 思路
在失败解法的基础上发现，整个算法最耗时的部分就是排序，提升效率的方式就是加快排序。参考了国际站的解法。在**插入的时候对数组进行二分法排序找到需要插入的位置**。
1. 确定left和right游标，设定一个循环条件left<right
2. 不断地比较中间值和num之间的大小来判断是让哪个游标变动
  - 如果是num小于中间值，那么意味num在左半部分，right游标移到这次的中间位置
  - 如果是大于，则说明在右边部分，left游标移到中间位置+1的地方
3. 在游标不断变化的过程中，最终left游标最终会放置在比mid数大或等于数所在的坐标位置
#### 代码
```java
class MedianFinder {
    private List<Integer> list;
    
    public MedianFinder() {
        list = new ArrayList();
    }

        public void addNum(int num) {
        if (list.isEmpty()) {
            list.add(num);
            return;
        }
        
        int left = 0, right = list.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2, val = list.get(mid);
            if (num < val) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        if (list.get(list.size() - 1) < num) {
            list.add(num);
        } else {
            list.add(left, num);
        }
    }

    public double findMedian() {
        int len = list.size(),  midNum = len / 2;
        return (len & 1) == 0 ? ((double) list.get(midNum - 1) + (double) list.get(midNum)) / 2 : list.get(midNum);
    }
}
```
### 收获
1. 学到了使用两个堆来解这类确定中位数的方式，思路非常巧妙。
2. 之后尝试的暴力解法，通过某一个部分的优化，也解出了问题，整个过程很有收获：
  1. 找到瓶颈
  2. 尝试优化的方法
  3. 如果失败，循环往复
## LeetCode_102
### 题目
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
```
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
```
返回其层次遍历结果：
```
[
  [3],
  [9,20],
  [15,7]
]
```
### 解法一
#### 思路
这题和429题很相似，使用bfs方式，使用记录层数节点个数的count变量就可以了。
#### 代码
```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> nodeLevel = new ArrayList<>();

            while (count-- > 0) {
                TreeNode node = queue.poll();
                nodeLevel.add(node.val);
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            result.add(nodeLevel);
        }

        return result;
    }
}
```
### 解法二
#### 思路
使用dfs递归方式，同时通过层级和数组下标的对应，在深度搜索过程中对指定的list里增加节点值
#### 代码
```java
class Solution {
    private List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }

        dfs(root, 0);
        return levels;
    }

    private void dfs(TreeNode node, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(node.val);
        
        if (node.left != null) {
            dfs(node.left, level + 1);
        }
        
        if (node.right != null) {
            dfs(node.right, level + 1);
        }
    }
}
```
### 收获
在做这题的时候，真的觉得轻松了很多，思路一下子就有了，刻意练习很有效果。
## LeetCode_547
### 题目
班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。

示例 1:
```
输入: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
输出: 2 
说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
第2个学生自己在一个朋友圈。所以返回2。
```
示例 2:
```
输入: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
输出: 1
说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
```
注意：
```
N 在[1,200]的范围内。
对于所有学生，有M[i][i] = 1。
如果有M[i][j] = 1，则有M[j][i] = 1。
```
### 解法一
#### 思路
通过寻找共同的根节点来确定圈子，可以使用并查集的思路，在国内站找到了UnionFind解法
1. 有一个数组保存当前元素的所属根元素的坐标**int[] parent**
2. 因为只需要知道最终共同认识的那个人，所以储存的是根节点，也因此需要进行**路径压缩**。
```java
class Solution {
    public void pathCompression(int[] parent, int p) {
        while (p != parent[p]) {
            //将压缩路径
            parent[p] = parent[parent[p]];
            //为了while条件时进行比较
            p = parent[p];
        }
    }
}
```
3. 还有一个数组用来保存每一个以它为根节点的这个朋友圈的等级，谁合并别人的次数多，谁更牛b，以后就继续合并别人(**int[] rank**)，当出现有人需要联合的时候，通过比较rank等级来决定谁做圈子的根节点。
4. 另有一个就是变量count，count用来记录朋友圈的个数，初始为总人数，也就是默认每个人是单独的一个圈子。当两个人中的一个准备进另一个圈子(**union**)的时候，count就需要-1
5. 然后就是遍历整个二维数组，对互为朋友(=1)的两个元素进行是否需要联合的判断：
  - 根节点不同就进行联合
  - 圈子数-1
6. 循环结束，返回count
#### 代码
```java
class Solution {
    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

    private class UnionFind {
        private int count;
        private int[] parent;
        private int[] rank;

        UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int n) {
            while (n != this.parent[n]) {
                this.parent[n] = this.parent[this.parent[n]];
                n = this.parent[n];
            }
            return n;
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }

            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }

            count--;
        }
    }
}
```
### 收获
熟悉和练习了并查集的解法，同时了解了如何进行路径压缩。
## LeetCode_310
### 题目
对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。

格式

该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。

你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。

示例 1:
```
输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3 

输出: [1]
```
示例 2:
```
输入: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5 

输出: [3, 4]
```
说明:
```
 根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
树的高度是指根节点和叶子节点之间最长向下路径上边的数量。
```
### 解法一
#### 思路
参考了国际站的解法，使用bfs拓扑排序，也就是每一次将叶子节点找到并从这个无向图中去掉，循环往复，一层层的摘掉这些叶子，直到找到最后1个或2个节点。
1. 用一个**List<Set<Integer>> list**维护edges中每个节点与其他与之直接关联的节点们的关系(从我这个节点出发，走一步就到的节点)
2. 用一个**List<Integer> leaves**来保存当前要摘的这层叶子节点们
3. 如果当前节点只有一个与之直接关联的节点，说明它就是要摘的叶子，把他放到leaves里(bfs起始的一层)
4. 然后开始bfs,条件是while(n > 2)，只要摘到小于等于2的时候，就说明摘完了
5. 通过遍历leaves，在循环体里：
   1. 摘叶子
   2. 放下一层要摘的叶子
6. 留到最后的叶子节点就是结果
#### 代码
```java
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        List<Set<Integer>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new HashSet<>());
        }
        for (int[] edge: edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (list.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();

            List<Integer> newLeaves = new ArrayList<>();
            for (int leave: leaves) {
                int node = list.get(leave).iterator().next();
                list.get(node).remove(leave);
                if (list.get(node).size() == 1) {
                    newLeaves.add(node);
                }
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }
}
```
### 收获
了解和练习了bfs拓扑排序