package Week_04.id_18;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LiveForExperience
 * @date 2019/6/24 21:25
 */
public class LeetCode_720_18 {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String result = "";
        Set<String> set = new HashSet<>();
        for (String word: words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                result = word.length() > result.length() ? word : result;
            }
        }
        return result;
    }
}
