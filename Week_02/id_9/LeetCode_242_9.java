package com.github.lifelab.leetcode.problemset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 有效的字母异位词 @see https://leetcode-cn.com/problems/valid-anagram/
 *
 * @author Weichao Li (liweichao0102@gmail.com)
 * @since 2019-06-16
 */
public class Solution242 {

    public boolean isAnagram(String s, String t) {
        if (Objects.isNull(s) || Objects.isNull(t)) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        char[] temp = new char[26];

        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
            temp[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (Objects.isNull(s) || Objects.isNull(t)) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        char[] sarray = s.toCharArray();
        char[] tarray = t.toCharArray();
        Arrays.sort(sarray);
        Arrays.sort(tarray);
        return Arrays.equals(sarray, tarray);
    }

    public boolean isAnagram2(String s, String t) {
        if (Objects.isNull(s) || Objects.isNull(t)) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> maps = new HashMap<>(t.length());
        for (int i = 0; i < s.length(); i++) {
            maps.compute(s.charAt(i), (k, v) -> maps.getOrDefault(k, 0) + 1);
            maps.compute(t.charAt(i), (k, v) -> maps.getOrDefault(k, 0) - 1);
        }
        return maps.values().stream().parallel().allMatch(e -> Objects.isNull(e) | e == 0);
    }
}