# 学习笔记

### 题目1

[Leetcode#104 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree//)
### 难点分析
递归的模板定义，终止条件的定义

### 解题思路
> 终止条件：空节点的高度是1
  drill down条件：左右子树递归的返回值的max+1

### 参考代码AC
```Java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
```


### 题目2
[Leetcode#703 数据流中的第K大元素](https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/)

### 难点分析
这道题的难点在于怎样思考到使用小顶堆的模型来抽象这种场景

### 解题思路
> 首先要想到使用堆这种数据结构来抽象这种第K大元素的场景，这种只有靠平时的积累。
而且要想到使用小顶堆来管理，而小顶堆在java中可以使用一个容量为k的优先队列，就可以很好地
解决这个问题。因为第K大元素，换句话说其实就是K个的优先队列里面最小的那个元素，就是头指针。

### 参考代码AC
```Java
class KthLargest {

    PriorityQueue<Integer> q;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<Integer>(k);
        for(int i:nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (q.size() < k) {
            q.offer(val);
        } else if(q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
```