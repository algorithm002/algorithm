package Week_01.id_18;

import java.util.Stack;

/**
 * @author LiveForExperience
 * @date 2019/6/5 13:28
 */
public class LeetCode_1047_18 {
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

    public String removeDuplicates1(String S) {
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
