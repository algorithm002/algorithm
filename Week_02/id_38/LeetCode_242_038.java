import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */
class LeetCode_242_038 {

    /**
     * hash
     * 执行用时：11ms，内存消耗：38.2mb
     * 时间：O(n), 空间：O(1),n为字符串长度
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        // check valid
        if (equals(s, t)) return true;
        if (length(s) != length(t)) return false;

        int[] charArr = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            charArr[s.charAt(i) - 'a']++;
            charArr[t.charAt(i) - 'a']--;
        }

        for (int i : charArr) {
            if (i != 0) return false;
        }
        return true;
    }

    /**
     * 将两string排序，然后判断是否相同
     * 执行用时：317ms，内存消耗：58.2mb
     * -。-
     * 自行实现的算法效率正是低，代码也一大坨
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (equals(s, t)) return true;
        if (length(s) != length(t)) return false;

        return equals(stringSort(s), stringSort(t));
    }

    public String stringSort(String s) {
        if (isEmpty(s)) return s;
        String[] sa = s.split("");
        Arrays.sort(sa);
        System.out.println(String.join("", sa));
        return String.join("", sa);
    }

    public boolean isEmpty(String s) {
        if (s == null || s.length() == 0) return true;
        return false;
    }

    public boolean equals(String s, String t) {
        if (isEmpty(s) && isEmpty(t)) return true;
        if (!isEmpty(s) && s.equals(t)) return true;
        return false;
    }

    public int length(String s) {
        if (isEmpty(s)) return 0;
        return s.length();
    }

    public static void main(String[] args) {
        LeetCode_242_038 testCode_242_038 = new LeetCode_242_038();
        System.out.print(testCode_242_038.isAnagram("ab", "ba"));
    }
}

