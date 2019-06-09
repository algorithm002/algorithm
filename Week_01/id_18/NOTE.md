# 学习笔记
## LeetCode_26_18
### 题目：
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

示例 1:
```
给定数组 nums = [1,1,2], 

函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 

你不需要考虑数组中超出新长度后面的元素。
```
示例 2:
```
给定 nums = [0,0,1,1,1,2,2,3,3,4],

函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

你不需要考虑数组中超出新长度后面的元素。
```
说明:
```
为什么返回数值是整数，但输出的答案是数组呢?

请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
```
你可以想象内部操作如下:
```
// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
```
### 解法一
#### 思路
看到这道题的第一反应就是和覃超老师PPT_**Day-1-2中第24页Array实战的第1题_remove zero**的解题思路很相似。可以用两个游标来解这道题，一个负责遍历数组，一个负责做特殊的工作，remove zero是把非0数放入该游标指向的位置，而这题是把不重复的数放入该游标指向的位置。
#### 解题过程
1. 一开始使用了和remove zero很类似的代码，结果出现的数组越界的问题:
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int nonDuplicatesIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[nonDuplicatesIndex++] = nums[i];
            }
        }
        
        return nonDuplicatesIndex;
    }
}
```
这时候的思路是，碰到第一个不重复的元素，我就把他放在第二个游标nonDuplicatesIndex指向的位置，然后让它向后移一位，同时第一个游标继续往后查。
但是这样就会导致遍历到最后一个元素的时候就会越界。

2. 于是就想，要么就比较游标i和它前一个元素，先解决越界的问题。同时，我也就要从下标1开始遍历，否则又得越界，那用人话来解释从1开始的话......又想了下，因为，数组第一个绝对就是不重复的呀，那放在nonDuplicatesIndex的位置天经地义啊，好了，逻辑自洽了。。。
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int nonDuplicatesIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[nonDuplicatesIndex++] = nums[i];
            }
        }
        
        return nonDuplicatesIndex;
    }
}
```
这次的提交结果，耗时是3ms，只打败了50%多的人，说明时间还可以优化。

3. 于是就想到了用如下的方式试一下，耗时居然提升到了2ms。。。不知道是瞎猫碰到死耗子，还是本身就有精度的误差，其实没什么区别。。。
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int nonDuplicatesIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            nums[nonDuplicatesIndex++] = nums[i];
        }
        
        return nonDuplicatesIndex;
    }
}
```
### 收获
当看完题目后，直接O(1)的从脑子里就闪出了remove zero的解题思路，当时感觉那叫一个爽啊。切身体会到五毒神掌，多做题真的很有用，让大脑形成了一种对某种题目的认知框架，可以辅助自己迅速找到解决问题的方案。
## LeetCode_242_18
### 题目
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:
```
输入: s = "anagram", t = "nagaram"
输出: true
```
示例 2:
```
输入: s = "rat", t = "car"
输出: false
```
说明:
```
你可以假设字符串只包含小写字母。
```
### 解法一
#### 思路
上来看到两个数比较，控制不住脾气，就是一顿**两个for的嵌套**。不过耗时1000ms+，有很大的优化空间。
### 解题过程
话不多说，就是干：
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] tc = t.toCharArray();
        for (char sc: s.toCharArray()) {
            for (int i = 0; i < tc.length; i++) {
                if (sc == tc[i]) {
                    tc[i] = '#';
                    break;
                }
            }
        }
        
        for (char c: tc) {
            if (c != '#') {
                return false;
            }
        }
        
        return s.length() == t.length();
    }
}
```
因为有两个for嵌套，所以时间复杂度是O(n^2)，效率不高。
### 解法二
#### 思路
两个字符串的比较，其实也可以想成是组成的字符个数的比较，可以用一个map来统计两个字符串中各个字符的个数是否相等。
#### 解题过程
这个话也不多说了，继续干：
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<String, Long> map = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (String ts: t.split("")) {
            if (map.containsKey(ts)) {
                map.put(ts, map.get(ts) - 1);
                continue;
            }
            return false;
        }
        
        for (Long value: map.values()) {
            if (value != 0) {
                return false;
            }
        }
        
        return true;    
    }
}
```
因为时间复杂度是O(n),所以时间确实是从一开始的1000ms缩短到了300ms不到，但是仍然只打败了5%的人,而且因为使用的是String，空间也多占用了20M。。。还可以优化。
### 解法三
#### 思路
先在解法二的基础上，优化下空间大小，那就使用char数组。
#### 解题过程
```java
public class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Integer, Long> map = s.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (char c: t.toCharArray()) {
            int ci = (int)c;
            if (map.containsKey(ci)) {
                map.put(ci, map.get(ci) - 1);
                continue;
            }
            return false;
        }

        for (Long value: map.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}
```
执行后，空间和解法一少了1M左右，同时速度比解法二也提升了，140ms了，但是还是只打败了5%，还可以优化。
### 解法四
#### 思路
在想出以上3种解法后，挣扎了10分多种，没再能想出更好的方法，于是使用五毒神掌第一式，看solution：
#### 解题过程
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs, ct);
    }
}
```
看完代码，就想自己怎么这么蠢，现成的好东西不用。。。
### 解法五
#### 思路
继续找solution中的好解法：
#### 解题思路
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] countArr = new int[26];
        
        for (int i = 0; i < cs.length; i++) {
            countArr[cs[i] - 'a']++;
            countArr[ct[i] - 'a']--;
        }
        
        for (int i: countArr) {
            if (i != 0) {
                return false;
            }
        }
        
        return ture;
    }
}
```
### 解法六
参考了其他同学的解法，直接使用素数相乘的方法，简直绝了
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101};
        BigInteger productS = BigInteger.valueOf(1);
        BigInteger productT = BigInteger.valueOf(1);
        for (int i = 0; i < s.length(); i++)
        {
            productS = productS.multiply(BigInteger.valueOf(prime[s.charAt(i) - 'a']));
        }
        for (int i = 0; i < t.length(); i++)
        {
            productT = productT.multiply(BigInteger.valueOf(prime[t.charAt(i) - 'a']));
        }
        return productS.compareTo(productT) == 0;
    }
}
```
发现solution的第2个解法与我之前想的第2、3种很像，但它没有使用map来映射，而是直接使用arr[index] - 'a'的方法，巧妙的利用数组下标来映射字母并计数。提交后速度变得只有几ms了，提升的非常明显。这个方法的时间复杂是O(n)。
### 收获
通过5种解法的摸索和学习过程，有两点的收获：
- 感觉把题目提交并成功，而且每一次都比上一次更优化的时候，这种反馈确实会上瘾，现在感觉每次空下来，都想刷道题爽一下了。
- 在自己尝试了3种解法之后，开始搜寻和学习网上优质解法的时候，在看的时候，可以结合自己的思维过程，更好的体会到别人解法的思路，学习起来更有效率了，而且也更容易记忆。
- 从解法六收获到的是，解法真的非常多，只要愿意思考。
## LeetCode_1047_18
### 题目
给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

在 S 上反复执行重复项删除操作，直到无法继续删除。

在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

示例：
```
输入："abbaca"
输出："ca"
解释：
例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
```
### 解法一
#### 思路
因为是比较相邻的两个字符是否相等，而且是在删去重复地内容后，继续不断比较地过程，所以非常像栈的push和pop的过程，所以想到了用栈来解决这道题(其实主要是题目分类在栈分类里：D)
#### 解题过程
1. 用一个栈来进行对字符数组遍历过程中压栈和出栈的过程；
2. 每次压栈之前都判断栈是否为空，或者栈顶字符是否与当前遍历元素相同；
3. 如果不同且非空，就压栈；
4. 否则就出栈，然后循环往复，直到遍历结束；
5. 之后再遍历一下这个栈，拼出字符串后得到结果。
```java
class Solution {
    public String removeDuplicates(String S) {
        if (S == null || "".equals(S)) {
            return S;
        }
        
        Stack<Character> stack = new Stack<>();
        for (char c: S.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        StringBuilder result = new StringBuilder();
        for (Character c: stack) {
            result.append(c);
        }

        return result.toString();
    }
}
```
提交结果后，耗时只打败了50%的人，可以继续优化。
### 解法二
#### 思路
在国际站看到了一个使用双游标的解法，发现自己是被作业的分类限制了思考，其实题目的解法和26题比较相似。
#### 解题过程
1. 使用两个指针
2. nonDuplicatesIndex游标用来指向保存没有被对对碰掉的元素所保存的位置
3. i指针用来遍历整个数组
4. nonDuplicatesIndex指针是从-1开始的，思路和我26题从1开始比较类似，区别在于最后new String的时候需不需要+1
5. 然后遍历的时候就判断是否为-1，或者是否不相同
6. 如果满足就++nonDuplicatesIndex，并将i遍历到的元素，写到nonDuplicatesIndex所指向的位置
7. 否则就让nonDuplicatesIndex回退，这样就相当于两个一样的元素对对碰掉了
```java
class Solution {
    public String removeDuplicates(String S) {
        if (S == null || "".equals(S)) {
            return S;
        }
        
        char[] cs = S.toCharArray();
        int nonDuplicatesIndex = -1;
        for (int i = 0; i < cs.length; i++) {
            if (nonDuplicatesIndex == -1 || cs[nonDuplicatesIndex] != cs[i]) {
                cs[++nonDuplicatesIndex] = cs[i];
            } else {
                nonDuplicatesIndex--;
            }
        }
        
        return new String(cs, 0, nonDuplicatesIndex + 1);
    }
}
```
### 收获
这道题的收获：
1. 面对题目时候，通过形成的认知框架迅速解题固然很好，但是也不能让自己被框架限制住思维，否则就像这道题一样只能想到栈的方式(可能只是因为自己做的太少，框架太差了。。。)。
2. 加深了双指针的使用方法。
3. 熟悉了栈的相关类型的解题思路。
## LeetCode_441_18
### 题目
你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。

给定一个数字 n，找出可形成完整阶梯行的总行数。

n 是一个非负整数，并且在32位有符号整型的范围内。

示例 1:
```
n = 5
硬币可排列成以下几行:
¤
¤ ¤
¤ ¤
因为第三行不完整，所以返回2.
```
示例 2:
```
n = 8
硬币可排列成以下几行:
¤
¤ ¤
¤ ¤ ¤
¤ ¤
因为第四行不完整，所以返回3.
```
### 思路
看到这题，看着一层层的往后推的图的样子，脑子里就直接想到了下面四段话：
1. terminator
2. process
3. drill down
4. restore

然后就开始写：
```java
class Solution {
    public int arrangeCoins(int n) {
        return doJob(0, 0, n);
    }
    
    private int doJob(int level, int sum, int n) {
        return sum + ++level > n ? --level : doJob(level, sum+level, n);
    }
}
```
满心等着ac，结果int类型溢出，导致虚拟机栈溢出。懵了。揉了揉脸，再看了下题目，差点抽自己耳光，最简单的数学题啊。。。**真的是手里拿着锤子，看什么都是钉子**。。。

于是又满怀信心的敲出了如下的代码：
```java
class Solution {
    public int arrangeCoins(int n) {
        int i = 0;
        for (int sum = 0; sum <= n;) {
            sum = (1 + ++i) * i / 2;
        }
        return --i;
    }
}
````
结果超时。。。
### 解法一
#### 思路
1. 其实明显不用从1开始算，直接使用求根公式就可以算出那个值
2. (m + 0.5)^2 = 2 * n - 0.25 =》 m = sqrt(2 * n - 0.25) - 0.5
3. 然后再求小于这个整数中最大的那个就可以了
#### 解题过程
```java
class Solution {
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(n * 2 + 0.25) - 0.5);
    }
}
```
坑爹，结果又没注意整数类型溢出，又报错，那就只能先转成double了：
```java
class Solution {
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(n * 2.0 + 0.25) - 0.5);
    }
}
```
这样问题就解决了。但压根没用到作业分类的二分法啊，所以要继续找答案。
### 解法二
#### 思路
在网上的留言讨论里找到了一个大开眼界的方法：
1. 这个解法从两头来处理这个n
2. 一头是从0开始，存做c，先用c和n作比较，如果小于n就c++
3. 但不是应该用**总和**来和n作比较吗？而且为什么要先比较再++呢？
4. 因为他另一头做的事情才是关键，他直接把c从n中减去
5. 然后用c再和被减去c的n再进行比较
6. 这样的原因是只要一直减去c，最终都会遇到最后一行作比较的时候，如果大于n了，那就说明n不够分配下一组+1的数了，c就是最后的行数。
#### 解题过程
理解了思路，做起来就方便了
```java
class Solution {
    public int arrangeCoins(int n) {
        int c = 0;
        while(c < n) {
            n -= ++c;
        }
        return c;
    }
}
```
但效果没有刚才直接使用求根公式的算法好。但是分类要求的二分查找是怎么玩的呢？
### 收获
1. 体会到数学是算法的基础，有时候直接拿数学简化公式以后，算起来会更快
2. 感觉先好好想一下怎么解题的思路，等想清楚了再做题，做题的感觉反而更爽，不过思考的过程确实很累，结合之前不断试错修改的过程，两种方式都有锻炼自己的地方。
## LeetCode_104_18
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
使用分治的思路
1. terminator：root为null的时候，返回当前层数；
2. prepare：层数加1；
3. subproblems下钻到当前节点的左右子树；
4. process & generate：比较左右子树返回的层数，向上返回最大值。
#### 解题过程
因为思路中涉及到了层数的概念，所以就需要新建一个函数，入参增加一个层数用来下钻的时候传递。
```java
class Solution {
    public int maxDepth(TreeNode root) {
        return doSearch(0, root);
    }
    
    private int doSearch(int level, TreeNode root) {
        //terminator
        if (root == null) {
            return level;
        }
        //prepare 
        level++;
        //subproblems  & prepare & generate result
        return Math.max(doSearch(level, root.left), doSearch(level, root.right));
    }
}
```
通过样板很快就写出了可以执行的代码，然后又再精简了一下
```java
public class LeetCode_104_18 {
    public int maxDepth(TreeNode root) {
        return doSearch(0, root);
    }

    private int doSearch(int level, TreeNode root) {
        return root == null? level: Math.max(doSearch(++level, root.left), doSearch(level, root.right));
    }
}
```
### 收获
具体题目和样板之间有时候并不能完全匹配，但是在做题的过程中能够体会到大致的思路是可以通过样板来指导的。通过做题进一步的熟练了分治的思考和代码的编写，写的速度比以前明显感觉快了。
## LeetCode_189_18
### 题目
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:
```
输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
```
示例 2:
```
输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
```
### 思路
首先想到的就是较为暴力的方法：
1. 移动k次
2. 每次移动一个数，时间复杂度是O(n)
### 解法一
```java
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        for (int i = 0; i < k; i++) {
            doMove(nums);
        }
    }
    
    private void doMove(int[] nums) {
        int store = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            int tmp = store;
            store = nums[i + 1];
            nums[i + 1] = tmp;
        }
        nums[0] = store;
    }
}
```
doMove函数负责定义每次移动的逻辑，代码中需要使用一个变量来保存需要移动的数。但这样的时间复杂度事O(n^2)
### 解法二
从上面的解法中可以发现：
1. 解法一每次只走一部，重复走了k次，但其实可以一步到位，这样可以减少一层循环嵌套。
  1. 从第一个元素开始遍历整个数组
  2. 第i个元素会放在i+k的位置
  3. i+k的元素则保存下来，i+2k的位置
  4. 以此类推
  5. 但是会有一个特殊情况，就是在过界以后，会进行%的处理，如果处理结束后回到了第一个元素的位置，那么因为第一个位置的元素已经去到该去的位置了，所以就从第二个元素开始继续。
  > 对于为什么回到第一个元素的位置后，就特殊处理为从后一个元素开始，没法很好的理解。
2. 碰到如下情况则可以直接返回：
  1. 数组的长度小于等于1；
  2. k==0的时候;
  3. k是数组长度的整数倍。
```java
class Solution {
    public void rotate(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length <= 1 || (k % nums.length == 0)) {
            return;
        }
        
        int index = 0;
        int start = 0;
        int store = nums[index];
        for (int i = 0; i < nums.length; i++) {
            index = index + k >= nums.length ? (index + k) % nums.length: index + k;
            int tmpStore = store;
            store = nums[index];
            nums[index] = tmpStore;
            if (index == start) {
                start = ++index;
                store = nums[index];
            }
        }
    }
}
```
### 解法三
这个解法是通过review同学代码学习到的：
1. 先将数组头尾的交换，相当于进行倒序排列。
2. 然后再以k为中心点，两边同时头尾交换的倒序排列
3. 这样就直接实现了，非常巧妙
4. 使用异或操作，实现原地的数值交换
```java
class Solution {
    public void rotate(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length < 2 || k % nums.length == 0) {
            return;
        }
        
        k %= nums.length;
        
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }
    
    private void swap(int[] nums, int head, int tail) {
        while (head < tail) {
            exchange(nums, head, tail);
            head++;
            tail--;
        }
    }
    
    private void exchange(int[] nums, int x, int y) {
        nums[x] ^= nums[y];
        nums[y] ^= nums[x];
        nums[x] ^= nums[y];
    }
}
```
### 收获
从这道题中学到的：
1. 前置条件检验的好，可以避免异常，同时能够提高效率。
2. 解法二思考了很久，无论是看题解还是自己思考，都debug了很久才了解了大概的意思，自己禁不住要人肉在脑中算一下整个过程，否则没办法很好的理解。这一点不知道该怎么克服，但至少找到了一个问题，也算是收获。
3. 解法三让我收获了异或的一种实用的使用方法，同时也了解一种非常巧妙地解题方式。
## LeetCode_15_18
### 题目
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。
```
例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```
### 思路
1. 3个数的和为0，意味着1个数和另2个数互为相反数。
2. 数组中的元素是重复的，而结果不能重复，所以可以先排序数组，从而方便遍历时候进行过滤
3. 可以使用一个指针遍历数组，另两个指针代表剩余元素的头尾指针，或者是另两个数，从而计算它们的和
### 解法一
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        int pointer = 0, head, tail, target;
        while (pointer < nums.length - 2) {
            if (pointer > 0 && nums[pointer] == nums[pointer - 1]) {
                pointer++;
                continue;
            }
            
            head = pointer + 1;
            tail = nums.length - 1;
            target = -nums[pointer];
            
            while (head < tail) {
                if (nums[head] + nums[tail] == target) {
                    result.add(Arrays.asList(nums[pointer], nums[head], nums[tail]));
                    
                    while (head < tail && nums[head] == nums[head + 1]) {
                        head++;
                    }
                    
                    while (head < tail && nums[tail - 1] == nums[tail]) {
                        tail--;
                    }
                    
                    head++;
                    tail--;
                } else if (nums[head] + nums[tail] < target) {
                    head++;
                } else {
                    tail--;
                }
            }
            
            pointer++;
        }
        
        return result;
    }
}
```
解题过程中：
1. return Collections.emptyList();是因为return null报错，要求的是空list。
2. while (pointer < nums.length - 2) 是因为数组最后的2个元素不需要遍历，因为没有剩余的元素可以和它们相加计算，或者说，它们的可能性在之前已经检查过了。
### 收获
做这道题目时，脑中有一个大概的思路，但具体的代码是通过review其他同学的过程清晰出来的，review和看sol一样可以帮助自己快速的找到思路，再通过对代码的思考，解题的过程就能清晰了。总之review是一件很棒的事情。学习他人的代码和思路对提升自己非常有帮助。
## LeetCode_21_18
### 题目
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：
```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```
### 思路
上来先想到的是循环，但循环的话应该是要嵌套的，而且感觉非常麻烦。在通过学习其他人的代码过程中，看到了使用递归的方式，思路如下：
1. 比较两个节点的值谁小，小的那个放在新的链表中
2. 然后把新增到新链表中的的节点的next节点(其实也就是两个链表中当前val较小的那个的后一个值)和另一个链表的比输的那个较大的节点再比较
3. 循环往复
4. 退出条件是某一个链表的节点比完了，也就说明，另一个链表剩下的节点一定比新增的链表的所有节点都大了，直接连在后面就可以了
### 解法一
```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
        {
            return l1 == null ? l2 : l1;
        }
        ListNode temp = l1.val < l2.val ? l1 : l2;
        temp.next = mergeTwoLists(temp.next, temp == l1 ? l2 : l1);
        return temp;
    }
}
```
### 收获
在理解这个递归解法的过程中，还是禁不住想去人肉递归一下，而且起始理解的时候也有些吃力，还是通过写下思路的方式，才能写出。还是需要多练习。