package Week_04.id_18;

import java.util.Arrays;

/**
 * @author LiveForExperience
 * @date 2019/6/26 12:59
 */
public class LeetCode_455_18 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int j = 0, count = 0, sl = s.length;

        for (int value : g) {
            while (j < sl) {
                if (value <= s[j++]) {
                    count++;
                    break;
                }
            }

            if (j == sl) {
                break;
            }
        }

        return count;
    }
}
