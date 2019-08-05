package week01;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/5  12:32
 * @描述  LeetCode: 242. 有效的字母异位词  https://leetcode-cn.com/problems/valid-anagram/
 *  最优解 ：Method 4: 时间复杂度 ： O(n)  空间复杂度： O(1)
 */
public class ValidAnagram {
    public static void main(String[] args) {
         ValidAnagram anagram = new ValidAnagram(); // 注意这里的空格和格式
         String s = "anagram", t = "nagaram";
        System.out.println(anagram.isAnagram4(s,t));
    }

    /**
     *  Method 1 :  排序比较法
     *      思路： 将两个 字母转化成 char 数组，再一一比较
     *      数组采用的排序方式是 快速排序，
     *      时间复杂度 ： O(2*n*logn + n)  空间复杂度： O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        final char[] charsOne = s.toCharArray();
        final char[] charsTwo = t.toCharArray();
        if(charsOne.length != charsTwo.length){
            return false;
        }
        Arrays.sort(charsOne);
        Arrays.sort(charsTwo);
        for(int i=0;i<charsOne.length;i++){
            if(charsOne[i]!=charsTwo[i]){
                return false;
            }
        }
        return true;
    }

    /**
     *  Method 2: 方法的简化版
     *  时间复杂度 ： O(2*n*logn)  空间复杂度： O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        final char[] charsOne = s.toCharArray();
        final char[] charsTwo = t.toCharArray();
        Arrays.sort(charsOne);
        Arrays.sort(charsTwo);
        return String.valueOf(charsOne).equals(String.valueOf(charsTwo));
    }

    /**
     * Method 3: HashMap 来解决；  额外的空间 map, O(n)
     *  时间复杂度 ： O(2n)  空间复杂度： O(n)
     */
    public boolean isAnagram3(String s, String t) {
         HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c : t.toCharArray()) {
            final Integer integer = map.get(c);
            if(integer==null){
                return false;
            }else if(integer>1){
                map.put(c,integer-1);
            }else{
                map.remove(c);
            }
        }
        return map.isEmpty();
    }

    /**
     * Method 4: 用 26 个字母的 数组来 进行操作； 第一个数组 出现的字母的数组就++ ； 第一个数组 出现的字母的数组就 -- ；
     * 时间复杂度 ： O(n)  空间复杂度： O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram4(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        final char[] charsOne = s.toCharArray();
        final char[] charsTwo = t.toCharArray();
        int[] array = new int[26];
        for(int i=0;i<s.length();i++){
            array[charsOne[i]-'a']++;
            array[charsTwo[i]-'a']--;
        }
        for (int i : array) {
            if(i!=0){
                return false;
            }
        }
        return true;
    }



    }
