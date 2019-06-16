package Week_01.id_18;

/**
 * @author LiveForExperience
 * @date 2019/6/10 13:17
 */
public class LeetCode_1021_18 {
    public String removeOuterParentheses(String S) {
        int count = 0, start = 1;
        char[] cs = S.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cs.length; i++) {
            count = cs[i] == '(' ? ++count : --count;
            if (count == 0) {
                sb.append(S, start, i);
                start = i + 2;
            }
        }
        return sb.toString();
    }
}
