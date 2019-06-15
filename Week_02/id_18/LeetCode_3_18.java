package Week_02.id_18;

import java.util.HashSet;
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
}
