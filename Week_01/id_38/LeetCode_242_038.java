/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 * 要点1:答案中不包含重复的三元组
 */
class LeetCode_242_038 {
    
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] hash = new int[26];
        for(int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < hash.length; ++i) {
            if (hash[i] != 0) return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        LeetCode_242_038 testCode_242_038 = new LeetCode_242_038();
        System.out.println(testCode_242_038.isAnagram("aaab", "baaa"));
    }
}

