package week01;


import java.util.*;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/5  14:18
 * @描述 LeetCode: 49. 字母异位词分组   https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams anagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        final List<List<String>> lists = anagrams.groupAnagram3(strs);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + ",");
            }
            System.out.println();
        }
    }

    /**
     * Method 1: 第一想法 对 数组当中的每一个元素的字母进行排序；然后使用map 来进行排序相同进行分组
     * 时间复杂度： O(NKlogK) ; 空间复杂度： O(NK)
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return null;
        }
        List<List<String>> lists = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            final char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = String.valueOf(chars);
            List<String> list = new ArrayList<>();
            if (map.get(temp) != null) {
                list = map.get(temp);
            }
            list.add(strs[i]);
            map.put(temp, list);
        }
        for (List<String> list : map.values()) {
            lists.add(list);
        }
        return lists;
    }

    /**
     * Method 2 : 在方法一的基础上面 进行简化；
     * 直接在数据循环时处理 字母异位词
     * 时间复杂度： O(N*KlonK) ; 空间复杂度： O(K)
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = String.valueOf(chars);
            if (map.get(temp) == null) { map.put(temp, new ArrayList<String>());}
            map.get(temp).add(strs[i]);
        }
        return new ArrayList<>(map.values());

    }

    /**
     * Method 3:  不使用字符串 转数组 排序； 用 26 个字母的数组 来存储 每个字母
     *
     * 时间复杂度： O(N*K) ; 空间复杂度：O(K)
     *
     */
    public List<List<String>> groupAnagram3(String[] strs) {
        if(strs.length==0){
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
             int[] ints = new int[26];
             char[] chars = str.toCharArray();
            for(int i=0;i<chars.length;i++){
                ints[chars[i]-'a']++;
            }
            String temp=Arrays.toString(ints);
             List<String> mapOrDefault = map.getOrDefault(temp, new ArrayList<>());
             mapOrDefault.add(str);
             map.put(temp,mapOrDefault);
        }
        return new ArrayList<>(map.values());
    }

}
