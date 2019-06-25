# 学习笔记
## LeetCode_720 词典中最长的单词
### 题目
给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。

若无答案，则返回空字符串。

示例 1:
```
输入: 
words = ["w","wo","wor","worl", "world"]
输出: "world"
解释: 
单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
```
示例 2:
```
输入: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
输出: "apple"
解释: 
"apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
```
注意:
```
所有输入的字符串都只包含小写字母。
words数组长度范围为[1,1000]。
words[i]的长度范围为[1,30]。
```
### 解法一
#### 思路
使用字符串排序的方法，原因：
- 长的单词必定需要由短的单词扩展而来，所以按照字符长度遍历的顺序和解题的要求符合
- 如果结果长度相同，按照字符ASCII大小排序

过程：
1. 对**String数组 words**先排序
2. 遍历数组，用**Set set**存储符合要求的**String word**
3. 如果**长度==1**或者**set里面有当前word去掉最后一个字符的字**(排序后的好处)
3. 用一个变量**result**存储结果
4. 通过字符的长度决定result是哪个(如果遍历到的字和结果长度相同，就不要了，排序的好处)
5. 遍历结束，返回result
#### 代码
```java
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String result = "";
        Set<String> set = new HashSet<>();
        for (String word: words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                result = word.length() > result.length() ? word : result;
            }
        }
        return result;
    }
}
```
### 解法二
#### 思路
构建一个字典树来解这道题。
- 字典树节点属性：
   - 当前节点的字符内容**data**
   - 当前节点是否有效**isWord**
   - 保存下层节点指针的数组**next**
- 字典树函数：
   - 插入**insert()**：
      1. 把字符串中每个字符按顺序生成字典树节点放入字典树中
      2. 将最有一个节点的isWord属性设置为true(起初在自己思考时，一直想不清如果我把每个字符串的字符都放入字典树中，怎么判断这个字符串是有效的，后来才想通，因为这个单词是依赖整个数组中所有单词衍生而来，所以只要标记最后一个字符，在后面检查的阶段中，只要这个单词的前几个字符所对应的字典树节点的isWord属性没有设置为true，就说明不符合题意)
   - 判断是否是符合要求的字符串**isBuild()**
      1. 遍历整个字符数组
      2. 从根节点出发依次必对字符对应的节点isWord属性是否为true
- 主方法：
   1. 遍历整个字符串数组，依次insert，生成字典树
   2. 再遍历字符串数组，获得符合题目要求同时字符串长度最长的单词
   3. 如果有若干单词长度一样的，就再依次比对字符，获得最后的结果
#### 代码
```java
class Solution {
    public String longestWord(String[] words) {
        TrieTree trieTree = new TrieTree();
        for (String word: words) {
            trieTree.insert(word);
        }

        String result = "";
        int len = 0;

        for (String word: words) {
            if (trieTree.isBuild(word) && word.length() > len) {
                result = word;
                len = result.length();
            } else if (trieTree.isBuild(word) && word.length() == len) {
                char[] wordCs = word.toCharArray();
                char[] resultCs = result.toCharArray();
                for (int i = 0; i < len; i++) {
                    if (wordCs[i] < resultCs[i]) {
                        result = word;
                        break;
                    } else if (wordCs[i] > resultCs[i]) {
                        break;
                    }
                }
            }
        }
        
        return result;
    }

    private class TrieTreeNode {
        private char data;
        private boolean isWord;
        private TrieTreeNode[] next;

        public TrieTreeNode(char data) {
            this.data = data;
            this.next = new TrieTreeNode[26];
        }
    }

    private class TrieTree {
        TrieTreeNode root = new TrieTreeNode('/');
        public void insert(String word) {
            char[] cs = word.toCharArray();
            TrieTreeNode node = root;
            for (char c: cs) {
                int index = c - 'a';
                if (node.next[index] == null) {
                    node.next[index] = new TrieTreeNode(c);
                }
                node = node.next[index];
            }

            node.isWord = true;
        }

        public boolean isBuild(String word) {
            char[] cs = word.toCharArray();
            TrieTreeNode node = root;
            for (char c: cs) {
                int index = c - 'a';
                if (!node.next[index].isWord) {
                    return false;
                }
                node = node.next[index];
            }
            return true;
        }
    }
}
```
### 收获
熟悉和练习了字典树结构及使用的解法。
## LeetCode_169_求众数
### 题目
给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:
```
输入: [3,2,3]
输出: 3
```
示例 2:
```
输入: [2,2,1,1,1,2,2]
输出: 2
```
### 解法一
#### 思路
暴力解法，直接用哈希表统计num的个数，当超过n/2的时候就返回。
时间复杂度：O(N)，最坏情况遍历整个数组
空间复杂度：O(N)，最坏情况保存n/2个元素
#### 代码
```java
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
        int len = nums.length / 2;
        for (Integer num: nums) {
            map.compute(num, (k, v) -> v == null ? 1 : ++v);
            if (map.get(num) > len) {
                return num;
            }
        }
        return 0;
    }
}
```
### 解法二
#### 思路
对数组排序，因为众数的定义是大于n/2个，所以在对数组排序后，下标n/2对应的元素一定是众数
#### 代码
```java
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
```
### 解法三
#### 思路
使用分治算法：
1. 不断切分整个数组，直到数组长度为1
2. 切下的左右两个子区间，去求它们的众数
   - 如果众数是一样的，那么就返回这个数
   - 如果众数不同，谁众数的数量多，那个就是众数，返回
3. 回溯到最后，返回那个值
#### 代码
```java
class Solution {
    public int majorityElement(int[] nums) {
        return divideConquer(nums, 0, nums.length - 1);
    }

    private int divideConquer(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = (right - left) / 2 + left;
        int leftMajorityNum = divideConquer(nums, left, mid);
        int rightMajorityNum = divideConquer(nums, mid + 1, right);

        if (leftMajorityNum == rightMajorityNum) {
            return leftMajorityNum;
        }

        long leftCount = count(nums, leftMajorityNum, left, mid);
        long rightCount = count(nums, rightMajorityNum, mid + 1, right);

        return leftCount > rightCount ? leftMajorityNum : rightMajorityNum;
    }

    private int count(int[] nums, int num,  int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
```
### 收获
熟悉和练习了分治算法