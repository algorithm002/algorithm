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
### 收获