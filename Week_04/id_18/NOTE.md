# 学习笔记
## LeetCode_720_词典中最长的单词
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
1. 有一个**Set set**存储符合要求的word，有一个**result**变量存储最终结果
2. 对**String数组 words**排序
3. 遍历数组，判断word，如果**长度==1**或者**set里面有当前word去掉最后一个字符的字**(因为是排序过的，所以比当前word短的word都判断过了，排序后的好处)，就存到set里
4. 通过字符的长度决定result是哪个
   - 如果遍历到的字比结果长度长，就替换result
   - 如果遍历到的字比结果长度短，result不变
   - 如果遍历到的字和结果长度相同，result也不变，因为它的ASCII码肯定比result大，排序的好处
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
- 时间复杂度：O(N)，最坏情况遍历整个数组
- 空间复杂度：O(N)，最坏情况保存n/2个元素
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
## LeetCode_455_分饼干
### 题目
假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

注意：
```
你可以假设胃口值为正。
一个小朋友最多只能拥有一块饼干。
```
示例 1:
```
输入: [1,2,3], [1,1]

输出: 1
```
```
解释: 
你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
所以你应该输出1。
```
示例 2:
```
输入: [1,2], [1,2,3]

输出: 2
```
```
解释: 
你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
你拥有的饼干数量和尺寸都足以让所有孩子满足。
所以你应该输出2.
```
### 解法一
#### 思路
1. 对两个数组从小到大排序
2. 使用两个循环，外面的循环遍历小孩的胃口值数组
3. 里面的循环遍历饼干分量
4. 区别是里面的循环不不需要每次都从头开始遍历，记录迭代的下标位置，每次都从那个位置继续，等同于这块饼干无论符不符合要求，要么被放弃了，要么被吃掉了
5. 判断当前的饼干是否满足当前小孩的胃口，如果满足就计数+1，否则就找下一块饼干
6. 直到饼干找完，或小孩找完为止，返回count。
#### 代码
```java
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int j = 0, count = 0, sl = s.length;

        for (int value : g) {
            while (j < sl) {
                if (value <= s[j++]) {
                    count++;
                    break;
                }
            }
            
            if (j == sl) {
                break;
            }
        }
        
        return count;
    }
}
```
#### 代码优化
```java
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0, si = 0, gl = g.length, sl = s.length;

        while (gi < gl && si < sl) {
            if (g[gi] <= s[si]) {
                gi++;
            }

            si++;
        }
        return gi;
    }
}
```
- 直接移动两个下标，循环时任意一个越界就停止。
- 孩子胃口的下标移动条件是满足饼干满足，同时移动的下标也代表了有多少个孩子吃饱了
- 无论是否满足要求，都移动饼干下标，要么吃掉了，要么遗弃了

时间复杂度：O(NlogN)，孩子胃口N，饼干logN
空间复杂度：O(1)
### 收获
熟悉和练习的贪心算法，在简化代码过程中也得到了学习
## LeetCode_784_字母大小写全排列
### 题目
给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

示例:
```
输入: S = "a1b2"
输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
```
```
输入: S = "3z4"
输出: ["3z4", "3Z4"]
```
```
输入: S = "12345"
输出: ["12345"]
```
注意：
```
S 的长度不超过12。
S 仅由数字和字母组成。
```
### 解法一
#### 思路
使用回溯算法进行搜索
1. 定义一个函数进行回溯，需要如下两个参数
   - 被遍历的字符串(补充：因String对象为final修饰的不可变类型，所以每次修改字符串会额外创建一个新的String对象，改为使用StringBuilder对象)
   - 当前层需处理的字符下标
2. 类似递归，以字符下标作为层数，一层层的下钻处理逻辑
3. 处理逻辑：
   - 当前要处理的字符是数字就继续下钻
   - 否则就分别改变当前字符为大小写，分别下钻。
4. 当字符串被搜索完毕，就将字符串放入一个list中，同时返回上一层
5. 整个过程结束后，将list返回
#### 代码
```java
class Solution {
    List<String> list = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        dfs(new StringBuilder(S), 0);
        return list;
    }

    private void dfs(StringBuilder sb, int index) {
        if (index == sb.length()) {
            list.add(sb.toString());
            return;
        }

        if (Character.isDigit(sb.charAt(index))) {
            dfs(sb, index + 1);
        } else {
            char c = sb.charAt(index);
            sb.setCharAt(index, Character.toLowerCase(c));
            dfs(sb, index + 1);
            sb.setCharAt(index, Character.toUpperCase(c));
            dfs(sb, index + 1);
        }
    }
}
```
#### 优化代码
参考了国内站的另一种回溯解法，其中讨论了为什么在步骤类似的情况下，这种算法的时间会更短，他的结论是在做判断字符是否为数字的动作时，直接使用ASCII码进行比较比**Character.isDigit**方法更快。

我也进行了尝试。而我的另一个不同是，我使用的是StringBuilder对象，而其使用的是字符数组。在使用优化的方法后，代码的执行时间果然减少了，同时空间占用的大小也减小了，原因应该是StringBuilder类型的对象中还维护了一些题目中不需要的属性。
```java
class Solution {
    List<String> list = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        dfs(S.toCharArray(), 0);
        return list;
    }

    private void dfs(char[] cs, int index) {
        if (index == cs.length) {
            list.add(new String(cs));
            return;
        }

        if (cs[index] < 'A') {
            dfs(cs, index + 1);
        } else {
            char c = cs[index];
            if (c > 64 && c < 91) {
                dfs(cs, index + 1);
                cs[index] = (char) (cs[index] + 'a' - 'A');
                dfs(cs, index + 1);
            } else {
                dfs(cs, index + 1);
                cs[index] = (char) (cs[index] + 'A' - 'a');
                dfs(cs, index + 1);
            }
        }
    }
}
```
### 收获
熟悉和练习了回溯算法
## LeetCode_70_爬楼梯
### 题目
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：
```
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
```
示例 2：
```
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
```
### 失败解法
#### 思路
使用递归的方法，和之前做的一个求斐波那契数列的题目类似，代码和思路都很直观、简单，但超时了。
时间复杂度：O(2^n)
#### 代码
```java
class Solution {
    public int climbStairs(int n) {
        return n <= 2 ? n : climbStairs(n - 1) + climbStairs(n - 2);
    }
}
```
### 解法一
#### 思路
求助国内站的官方解法二，其对解法一(思路和我的失败解法类似)进行了优化，用到了记忆化递归。因为每次下钻的过程中，会有重复的步数，把已经计算过的部署放在数组里记录，就可以省去很多的步骤。
#### 代码
```java
class Solution {
    public int climbStairs(int n) {
        return climbStairs(n, new int[n + 1]);
    }
    
    private int climbStairs(int n, int[] nums) {
        if (n <= 2) {
            return n;
        }

        if (nums[n] > 0) {
            return nums[n];
        }

        int num = climbStairs(n - 1, nums) + climbStairs(n - 2, nums);
        nums[n] = num;
        
        return num;
    }
}
```
### 解法二
#### 思路
看了国内站官方解法三对于动态规划解法的讲解，发现其思路和我解法一二的思路有部分是基本一致的：**dp[i] = dp[i - 1] + dp[i - 2]**。

从覃老师周三一开始对动态规划的讲解中了解到，这题是属于一维的动态规划的，使用一维数组dp[]
- 数组下标对应的是台阶数
- 下标对应的元素代表的是走当前台阶数有的解法

因为题目定义每次只能是1或者2步，所以到达当前台阶i的必由路径一定是
- i - 1级台阶直接走1级
- i - 2级台阶直接走2级

于是到达i级台阶的方法数dp[i]就是dp[i - 1] + dp[i - 2]，也就是从第3级开始，每一级的结果就是前一两级结果之和。
- 时间复杂度：O(N)
- 空间复杂度：O(N)
#### 代码
```java
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
```
#### 优化代码
在写如上代码时发现，其实整个过程主要出现的就是三个变量
- 当前的数
- 前一位的数
- 前二位的数

所以不需要使用一个n+1位的数组来保存当前值，只需要3个变量就可以了。于是对解法二的代码进行了优化
```java
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        
        return second;
    }
}
```
但执行结果显示，空间没有减少，没办法解释，希望有人解惑。
### 解法三
#### 思路
使用数学公式解，真的快。
#### 代码
```java
class Solution {
    public int climbStairs(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }
}
```
### 收获
练习和熟悉了动态规划及递归，还学了点数学。
## LeetCode_208_实现Trie(前缀树)
### 题目

### 解法
#### 思路
和720题构建Trie树的思路基本一致。
#### 代码
```java
class Trie {
    private static final int SIZE = 26;
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (isEmpty(word)) {
            return;
        }

        char[] cs = word.toCharArray();
        TrieNode node = root;
        for (char c: cs) {
            int index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new TrieNode();
                node.next[index].data = c;
            }
            node = node.next[index];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        if (isEmpty(word)) {
            return false;
        }

        char[] cs = word.toCharArray();
        TrieNode node = root;
        for (char c: cs) {
            int index = c - 'a';
            if (node.next[index] != null) {
                node = node.next[index];
            } else {
                return false;
            }
        }

        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        if (isEmpty(prefix)) {
            return false;
        }

        TrieNode node = root;
        char[] cs = prefix.toCharArray();
        for (char c: cs) {
            int index = c - 'a';
            if (node.next[index] != null) {
                node = node.next[index];
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isEmpty(String word) {
        return word == null || word.length() == 0;
    }

    private class TrieNode {
        private char data;
        private TrieNode[] next;
        private boolean isWord;

        TrieNode() {
            this.next = new TrieNode[SIZE];
            this.isWord = false;
        }
    }
}
```
### 收获
再次熟悉了Trie树的构建代码。同时在构建过程中，发现startWith和search有一部分代码是重复的，在想要抽出这部分代码复用的过程中，没有考虑到函数中的引用指针的问题。
```java
class Problem {
    boolean search(String word) {
        TrieNode node = root;
        boolean hasStr = hasStr(word, node);
        return hasStr ? node.isWord : hasStr;
    }
    
    private boolean hasStr(String word, TrieNode node) {
        for (char c: word.toCharArray()) {
            //......
            if (node.next[index] == null) {
                return false;
            }
            node = node.next[index];
        }
        return true;
    }
}
```
这里的node其实还是指向的root。最后只能老实的继续在两个函数中写类似的代码。