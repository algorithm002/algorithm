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
## LeetCode_104
### 题目

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