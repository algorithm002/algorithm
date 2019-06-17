import java.util.HashSet;

public class LeetCode_3_05 {

    /**
     * 计算 字符串中不含有重复字符的最大子串的长度
     * - 要点 滑动窗口 HashSet
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        HashSet<Character> window = new HashSet<>();
        int i = 0, j = 0, maxLength = 0;

        while (i < length && j < length) {
            if (!window.contains(s.charAt(j))) {
                window.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j - i);
            }else{
                window.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }

}
