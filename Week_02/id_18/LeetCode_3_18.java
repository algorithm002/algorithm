package Week_02.id_18;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author LiveForExperience
 * @date 2019/6/15 22:04
 */
public class LeetCode_3_18 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        return doCheck(s);
    }

    private int doCheck(String s) {
        Set<Character> set = new HashSet<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (set.contains(c)) {
                return Math.max(set.size(), doCheck(s.substring(s.indexOf(c) + 1)));
            }
            set.add(c);
        }

        return set.size();
    }


    public int lengthOfLongestSubstring1(String s) {
        Deque<Character> characterDeque = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characterDeque.contains(c)) {
                int len = characterDeque.size();
                if (len > result) {
                    result = len;
                }
                while (c != characterDeque.peek()) {
                    characterDeque.poll();
                }
                characterDeque.poll();
            }
            characterDeque.add(c);
        }
        int size = characterDeque.size();
        return size > result ? size : result;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        Set<Character> set = new HashSet<>();
        return doCheck(s, set);
    }

    private int doCheck(String s, Set<Character> set) {
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (set.contains(c)) {
                int len = set.size();
                set.clear();
                return Math.max(len, doCheck(s.substring(s.indexOf(c) + 1), set));
            }
            set.add(c);
        }

        return set.size();
    }
}
