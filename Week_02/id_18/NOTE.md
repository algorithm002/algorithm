# 学习笔记
## LeetCode_1
### 题目
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:
```
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```
### 解法一
#### 思路
1. 2个for循环嵌套，暴力
2. 时间复杂度O(n^2)
3. 空间复杂度O(1)
#### 代码
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        
        return new int[2];
    }
}
```
### 解法二
#### 思路
1. 先遍历数组，把元素作为key，下标作为value，放入hash表，这样也做到了去重
2. 再遍历一遍数组，先计算target和当前元素的差，在hash表中查找这个差对应的下标，且不是当前元素的下标
3. 这样时间复杂度就是O(n)
4. 空间复杂度因为多了个map，所以是O(n)
#### 代码
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j) && i != map.get(j)) {
                return new int[]{i, map.get(j)};
            }
        }

        return new int[2];
    }
}
```
### 解法三
#### 思路
1. 基于解法二，其实不需要先遍历一边数组，全部放到map里，可以边遍历变放
2. 这样也就不用判断是否重复使用当前元素
3. 最坏情况会遍历整个数组，所以时间复杂度是O(n)
4. 同样的空间复杂度和解法三类似，最坏情况下空间复杂度是O(n)
#### 代码
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                return new int[]{i, map.get(j)};
            }
            map.put(nums[i], i);
        }

        return new int[2];
    }
}
```
### 收获
算法可以不断地迭代改进，像生物进化一样，非常有趣。
## LeetCode_236
### 题目
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

> According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:
```
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
```
Example 2:
```
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
```
### 解法一
#### 思路
dfs路径上最早重叠的那个节点，就是它们的最早祖先节点。
1. 不断地向左右子节点搜索，如果找到返回true，否则false
2. 判断当前节点是不是p或q的一个
3. 如果以上三种情况有2种是true
4. 那么说明当前节点就是最早祖先节点
#### 代码
```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        doRecurse(root, p, q);
        return result;
    }

    private boolean doRecurse(TreeNode current, TreeNode p, TreeNode q) {
        if (current == null) {
            return false;
        }

        int left = doRecurse(current.left, p, q) ? 1 : 0;
        int right = doRecurse(current.right, p, q) ? 1 : 0;
        int mid = current.val == p.val || current.val == q.val ? 1 : 0;

        if (mid + left + right >= 2) {
            result = current;
        }

        return mid + left + right > 0;
    }
}
```
### 解法二
#### 思路
使用bfs查找两个节点，同时记录查找过程中的路过的父节点
1. 使用bfs标配的队列
2. 使用map记录路过的父节点，这样查询父节点的时间复杂度就是O(1)
3. 查找两个节点，当全部查到时开始生成查找p节点的父节点路径的集合
4. 再用这个集合去让q节点的父节点来匹配，第一个匹配上的就是最早祖先
#### 代码
```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        
        stack.push(root);
        parents.put(root, null);
        
        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            TreeNode current = stack.pop();
            
            if (current.left != null) {
                stack.push(current.left);
                parents.put(current.left, current);
            }
            
            if (current.right != null) {
                stack.push(current.right);
                parents.put(current.right, current);
            }
        }
        
        Set<TreeNode> pAncestors = new HashSet<>();
        while (p != null) {
            pAncestors.add(p);
            p = parents.get(p);
        }
        
        while (!pAncestors.contains(q)) {
            q = parents.get(q);
        }
        
        return q;
    }
}
```
### 解法三
#### 思路
使用dfs非递归的方法(stack)：
1. 从左子树开始向下查找，同时更新当前节点的状态
  - 左右都查过
  - 左边查好了
  - 还没查好
2. 通过栈不断地向下查，如果发现了和p或q相同的节点，就把它作为LCA，同时记录已经找到一个节点
3. 如果左边检查完，那么开始检查右边
4. 如果两边检查完，都没有找到全部两个目标节点，就把这个节点弹出，把这个弹出节点的父节点标记为LCA
5. 循环往复，直到找到两个节点为止
#### 代码
```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = null;

        boolean oneFound = false;

        Stack<Object[]> stack = new Stack<>();
        
        stack.push(new Object[]{root, 2});

        TreeNode childNode = null;
        
        while (!stack.isEmpty()) {
            Object[] parentArr = stack.peek();
            if (parentArr[0] == null) {return p;}
            TreeNode parentNode = (TreeNode) parentArr[0];
            int parentState = (int) parentArr[1];
            if (parentState != 0) {
                if (parentState == 2) {
                    if (parentNode == p || parentNode == q) {
                        if (oneFound) {
                            return lca;
                        } else {
                            lca = (TreeNode)stack.peek()[0];
                            oneFound = true;
                        }
                    }
                    childNode = parentNode.left;
                } else {
                    childNode = parentNode.right;
                }
                
                stack.pop();
                stack.push(new Object[]{parentNode, parentState - 1});
                
                if (childNode != null) {
                    stack.push(new Object[]{childNode, 2});    
                }
            } else {
                if (stack.pop()[0] == lca && oneFound) {
                    lca = (TreeNode) stack.peek()[0];
                }
            }
        }
        return lca;
    }
}
```
### 收获
熟悉了BFS和DFS的搜索方式，对递归有了进一步的理解。
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
使用dfs的递归方式
1. 一开始没有审清除题目，对于从根节点到最近叶子节点的最短路径上的节点数量没有理解
2. 叶子节点应该是没有左右子树的节点
3. 所以如果只有一个节点，那么只递归下钻有节点地一边，另一边就不管了
4. 然后只有当左右都为null的时候才开始计数
5. 然后开始返回，同时还要有一个变量存储左右节点的最小的那个值，初始的时候用int的最大值
6. 然后每一层返回的时候都需要+1，代表层数的累加。
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
        
        int depth = Integer.MAX_VALUE;
        if (root.left != null) {
            depth = Math.min(minDepth(root.left), depth);
        }
        
        if (root.right != null) {
            depth = Math.min(minDepth(root.right), depth);
        }
        
        return depth + 1;
    }
}
```
### 收获
审清题目很重要，就像理解需求一样，如果没搞清楚，搞半天也是瞎弄。
## LeetCode_783
### 题目
给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。

示例：
```
输入: root = [4,2,6,1,3,null,null]
输出: 1
解释:
注意，root是树结点对象(TreeNode object)，而不是数组。
```
给定的树 [4,2,6,1,3,null,null] 可表示为下图:
```
          4
        /   \
      2      6
     / \    
    1   3  

最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
```
注意：
```
二叉树的大小范围在 2 到 100。
二叉树总是有效的，每个节点的值都是整数，且不重复。
```
### 解法一
#### 思路
二叉搜索树的两个定义，老师需要我们O(1)的时间复杂度来反应：
1. 所有的左子树都小于根节点，所有的右子树都大于根节点，循环往复
2. 中序搜索的路径是升序的
所以直接就反应了使用dfs递归搜索的方式，但是没办法确定具体的逻辑，于是参考了国际站的方法：
1. 左边子树的差值就是上一个节点减去当前节点
2. 右边子树的差值就是当前节点减去上一个节点
3. 然后加上要记录的最小值
4. 于是涉及到的所有参数就是4个
  - 当前节点
  - 上一个节点(用左和右两个参数表示，因为不同的运算方式)
  - 最小值
5. 然后就是递归运算，求左右子树返回的差值中的最小值
#### 代码
```java
class Solution {
    public int minDiffInBST(TreeNode root) {
        return doSearch(root, null, null, Integer.MAX_VALUE);
    }

    private int doSearch(TreeNode root, TreeNode leftNode, TreeNode rightNode, int min) {
        if (root == null) {
            return min;
        }
        
        int left = leftNode == null ? Integer.MAX_VALUE : leftNode.val - root.val;
        int right = rightNode == null ? Integer.MAX_VALUE : root.val - rightNode.val;
        
        min = Math.min(Math.min(left, right), min);

        int leftChild = doSearch(root.left, root, rightNode, min);
        int rightChild = doSearch(root.right, leftNode, root, min);
        return Math.min(leftChild, rightChild);
    }
}
``` 
### 收获

## LeetCode_235
### 题目

### 解法一
#### 思路
二叉搜索树的中序搜索是升序的，所以最早祖先就是
1. node >= q && node <= p
2. node <= q && node >= p
这样直接dfs就能查到这个节点
#### 代码
```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (found(root, p, q)) {
            return root;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            if (node != null) {
                if (found(node, p, q)) {
                    return node;
                }

                stack.push(node.left);
                stack.push(node.right);
            }
        }
        
        return null;
    }
    
    private boolean found(TreeNode node, TreeNode p, TreeNode q) {
        return p.val <= node.val && q.val >= node.val || 
                p.val >= node.val && q.val <= node.val;
    }
}
```
### 解法二
#### 思路
借鉴国际站的dfs递归解法，同时对解法一的代码进行了优化，速度快了很多，应该算是进行了剪枝。
1. 如果q和p的值都小于root，就搜索左子树
2. 如果都大于root就搜索右子树
3. 否则就说明当前节点一定是如下三种情况，且无论哪种情况，当前节点都是lca
  - p是当前节点，且q也在这个路径上
  - 如上，只是p和q换一下
  - p和q分别在当前节点的左右子树的路径上
#### 代码
```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        
        if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }  
    }
}
```
如下是对解法一的优化代码：
```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                if (p.val < node.val && q.val < node.val) {
                    stack.push(node.left);
                } else if (p.val > node.val && q.val > node.val){
                    stack.push(node.right);
                } else {
                    return node;
                }
            }
        }

        return null;
    }
}
```
### 收获