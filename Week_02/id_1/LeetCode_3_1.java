package week02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/11  14:40
 * @描述      LeetCode : 3. 无重复字符的最长子串        https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring4("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring4("bbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring4("pwwkew"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring4(" "));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring4(""));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring4("c"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring4("abc"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring4("abba"));
    }

    /**
     *  Method 1 : 暴力法
     */
    public int lengthOfLongestSubstring1(String s) {
        int max=0;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j++){
                if(booleanSet(s,i,j)){
                    max=Math.max(j-i,max);
                }
            }
        }
        return max;
    }

    private boolean booleanSet(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for(int i=start;i<end;i++){
            if(set.contains(s.charAt(i))) return false;
            set.add(s.charAt(i));
        }
        return true;
    }

    /**
     *  Method 2 : 使用 Set，使用 快慢指针
     *  时间复杂度 ： O(N*N)
     *  空间复杂度 ： O(N)
     */
    public int lengthOfLongestSubstring2(String s) {
        int max=0,i=0,j=0;
        Set<Character> set = new HashSet<>();
        while (i<s.length() && j<s.length() ){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max=Math.max(max,j-i);
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    /**
     *  Method 3 : 使用 map ，与上面类似
     *  时间复杂度 : O(N)
     *  空间复杂度 : O(N)
     */
    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max=0;
        int count=0;
        for(int j=0;j<s.length();j++){
            if(map.containsKey(s.charAt(j))){
                count=Math.max(map.get(s.charAt(j)),count);
            }
            max=Math.max(max,j-count+1);
            map.put(s.charAt(j),j+1);
        }
        return max;
    }

    /**
     *  Method 4 : 使用数组
     */
    public int lengthOfLongestSubstring4(String s) {
        final int[] ints = new int[128];
        int max=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            count=Math.max(ints[s.charAt(i)],count);
            max=Math.max(max,i-count+1);
            ints[s.charAt(i)]=i+1;
        }
        return max;
    }






    /**
     *  Error
     *  Method 0 :  第一想法 循环字符串里面的字符，
     *      最开始的思维方式使用数组是对的； 这样子的方式不对
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("") || s.equals(" ")) return s.length();
        int[] ints = new int[256];
        int count=0;
        int max=0;
        for (char c : s.toCharArray()) {
            if(ints[c]==1){
                ints=new int[256];
                count=1;
            }else{
                count++;
            }
            max=Math.max(max,count);
            ints[c]++;
        }
        final char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){

        }
        return max;

    }
}
