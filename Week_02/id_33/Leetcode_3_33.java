

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxStr = 0;
        Map<Character, Integer> map = new HashMap<>(); 
        int temp = 0;
        for(int i = 0;i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                temp = Math.max(map.get(s.charAt(i)), temp);
            }
            maxStr = Math.max(maxStr, i-temp+1);
            map.put(s.charAt(i),i+1);
        }
        return maxStr;
    }
}

