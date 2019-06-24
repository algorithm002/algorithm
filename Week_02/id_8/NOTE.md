## 前言

### 题目1
[Leetcode#242 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)

### 难点分析
> 这道题目的难点在于单词中可能存在多个相同的字符，常用的简单KV需要使用整数来表示value。

### 解题思路
> 首先可以想到的是，如果两个单词的长度不一致，就直接可以返回false了。
然后开始构建map, 假设前面单词是a，后面单词是b，则可以以a为标准构建这个map。
如果存在这个字符，就将该字符的value+1，否则不存在直接置为1。
然后遍历b，对每一个字符，在前面以a为标准创建出来的map中检查，将存在的那个字符对应的value减一。
最后只要是不是这个map是不是全是0就行了。

### 参考代码AC
```Java
class Solution {
    public boolean isAnagram(String s, String t) {
        // 优化，直接返回false
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        // 构建hashmap
        for (int i = 0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        // 判断t
        for (int i = 0; i<t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }
        System.out.println(map.get('a'));
        for (int i = 0; i<s.length(); i++) {
            if (map.get(s.charAt(i)) != 0){
                System.out.println(s.charAt(i)+"不是0");
                return false;
            }
        }
        return true;
    }
}
```

### 题目2
[Leetcode#236 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)
### 难点分析
>这道题的思路挺难想的，可以通过先看答案的方式，理解就行了。

### 解题思路
>这道题本来的解法是这样的，相当于要双重递归了，先DFS每个根节点，然后对每个根节点的左右
 子树，分别再使用DFS来判断目标节点是否包含在书中。就算使用了一些剪枝的技巧，也超时。然后
 就想了，是否可以一次递归就搞定，答案是肯定的。
 优化的思路在于，节点一定都存在，所以只要right == null，就可以断定都在left中，并且祖先就是left
 反之亦然

### 参考AC代码
```Java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }
}
```
