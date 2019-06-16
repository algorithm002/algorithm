import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedMap = new HashMap<>();
        for (String word : strs) {
            char[] charWord = word.toCharArray();
            Arrays.sort(charWord);
            String newStr = new String(charWord);
            sortedMap.putIfAbsent(newStr,new ArrayList<>());
            sortedMap.get(newStr).add(word);
        }
        return new ArrayList<>(sortedMap.values());
    }
}

