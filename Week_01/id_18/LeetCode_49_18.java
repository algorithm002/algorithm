package Week_01.id_18;

import java.util.*;

/**
 * @author LiveForExperience
 * @date 2019/6/10 12:47
 */
public class LeetCode_49_18 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String tmp = String.valueOf(cs);
            if (!map.containsKey(tmp)) {
                map.put(tmp, new ArrayList<>());
            }
            map.get(tmp).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
