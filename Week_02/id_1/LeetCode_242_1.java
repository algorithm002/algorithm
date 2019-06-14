package week02;

import java.util.Arrays;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/11  12:37
 * @描述 LeetCode :  242. 有效的字母异位词       https://leetcode-cn.com/problems/valid-anagram/
 */
public class ValidAnagram242 {
    public static void main(String[] args) {
        System.out.println(new ValidAnagram242().isAnagram("anagram", "nagaram"));
        System.out.println(new ValidAnagram242().isAnagram("rat", "car"));
    }

    /**
     * Method 1 : 把两个字符串 转化成 char 数组，在排序比较两者是否一致
     * 字符串 转化成 数组 ，额外开销空间 两个数组
     * 数组内 排序 采用 快速排序，时间复杂度 NlogN
     * 时间复杂度 : O(2NlogN)  ;
     * 空间复杂度 ： O(N)    ；   N 为 字符串的长度
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        final char[] charsOne = s.toCharArray();
        final char[] charsTwo = t.toCharArray();
        Arrays.sort(charsOne);
        Arrays.sort(charsTwo);
        return String.valueOf(charsOne).equals(String.valueOf(charsTwo));
    }

    /**
     * Method 2 :  用一个 26 位 长度的数组来保存字符串内的字符数量。 无需排序
     * 第一个字符串中的字符 数组中的数量 ++
     * 第二个字符串中的字符 数组中的数量 --
     *  时间复杂度 ： O(N)    ；
     *  空间复杂度 ： O(2N)   ;   N 为 字符串的长度
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        final int[] array = new int[26];
        final char[] charsOne = s.toCharArray();
        final char[] charsTwo = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            array[charsOne[i] - 'a']++;
            array[charsTwo[i] - 'a']--;
        }
        for (int i : array) {
            if (i != 0) return false;
        }
        return true;
    }
}
