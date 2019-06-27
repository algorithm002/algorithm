package Week_04.id_18;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiveForExperience
 * @date 2019/6/27 12:47
 */
public class LeetCode_784_18 {
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

    public List<String> letterCasePermutation1(String S) {
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
