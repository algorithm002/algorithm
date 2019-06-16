//Given a string, find the length of the longest substring without repeating characters.
//
//
// Example 1:
//
//
//Input: "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//
//
//
// Example 2:
//
//
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//
//
//
// Example 3:
//
//
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//
//
//
//

package com.llz.algorithm.algorithm2019.secondweek;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode_3_2 {


    /**
     * Referenced from solution by using sliding window.
     * Time complexity is O(n) and space complexity is O(n) (max value of n is the length of string).
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringBySW(String s) {
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int length = s.length();
        int i = 0, j = 0;
        while (i < length && j < length) {
            if (!set.contains(s.charAt(j))) {
                maxLength = Math.max(maxLength, j - i + 1);
                set.add(s.charAt(j++));
            } else
                set.remove(s.charAt(i++));
        }
        return maxLength;
    }

    /**
     * An optimised version of lengthOfLongestSubstringBySW by further reducing iteration times.
     * Time complexity is O(n) and space complexity is O(n).
     * <p>
     * Watch the right boundary!
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringBySWOptimized(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int length = s.length();
        int i = 0, j = 0;
        while (i < length && j < length) {
            Character c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(map.get(c) + 1, i);
            }
            map.put(c, j++);
            maxLength = Math.max(maxLength, j - i);
        }
        return maxLength;
    }

    private int maxLength = 1;

    /**
     * Brutal Force
     * Time complexity is O(n^3) and space complexity is O(n^3).
     * Time Limit Exceed
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringByBrutalForce(String s) {
        if (null == s || s.length() == 0)
            return 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++)
                checkSubStr(i, j, s);
        }
        return maxLength;
    }

    public void checkSubStr(int begin, int end, String s) {
        Set<Character> set = new HashSet<>();
        String subStr = s.substring(begin, end + 1);
        for (int i = 0; i < subStr.length(); i++) {
            if (set.contains(subStr.charAt(i)))
                return;
            else
                set.add(subStr.charAt(i));
        }
        if (maxLength < (end - begin + 1))
            maxLength = end - begin + 1;
    }

    public static void main(String[] args) {
        LeetCode_3_2 l = new LeetCode_3_2();
        System.out.println(l.lengthOfLongestSubstringBySWOptimized("tmmzuxt)"));
    }
}
