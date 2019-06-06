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
发现solution的第2个解法与我之前想的第2、3种很像，但它没有使用map来映射，而是直接使用arr[index] - 'a'的方法，巧妙的利用数组下标来映射字母并计数。提交后速度变得只有几ms了，提升的非常明显。这个方法的时间复杂是O(n)。
### 收获
通过5种解法的摸索和学习过程，有两点的收获：
- 感觉把题目提交并成功，而且每一次都比上一次更优化的时候，这种反馈确实会上瘾，现在感觉每次空下来，都想刷道题爽一下了。
- 在自己尝试了3种解法之后，开始搜寻和学习网上优质解法的时候，在看的时候，可以结合自己的思维过程，更好的体会到别人解法的思路，学习起来更有效率了，而且也更容易记忆。
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
3. digging into
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