package com.leecode.week02;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 */
public class LeetCode_242_35 {
    public static void main(String[] args) {
        LeetCode_242_35 lc=new LeetCode_242_35();
        System.out.println(lc.isAnagram("anagram","nagaram"));

        System.out.println(lc.isAnagram("rat","art"));
        System.out.println(lc.isAnagram("rat"," car"));
        //Arrays.equals("anagram".toCharArray(),"nagaram".toCharArray());
    }

    public boolean isAnagram(String s, String t)
    {
        if(s==null||t==null||s.length()!=t.length()){
            return  false;
        }
        int[]  sArr=new int[128];
        int[]  tArr=new int[128];
        char[] sChs=s.toCharArray();
        char[] tChs=t.toCharArray();

        for(int i=0;i<sChs.length;i++){
            sArr[sChs[i]]++;
            tArr[tChs[i]]++;
        }


        return Arrays.equals(sArr,tArr);
    }

    public boolean isAnagram_v0(String s, String t) {
        if(s.length()!=t.length()){
            return  false;
        }
        char[] bys= s.toCharArray();
        Arrays.sort(bys);

        char[] byt= t.toCharArray();
        Arrays.sort(byt);

        int i = 0;
        int n = byt.length;
        while (n-- != 0) {
            if (bys[i] != byt[i])
                return false;
            i++;
        }

        return true;
    }

    /**
     *大神的做法
     *
     * public boolean isAnagram(String s, String t) {
     *         if(s == null || t == null || s.length() != t.length()) return false;
     *         int[]one = new int[128];
     *         int[]two = new int[128];
     *         for(char c: s.toCharArray()) one[c]++;
     *         for(char c: t.toCharArray()) two[c]++;
     *
     *         return Arrays.equals(one,two);
     *     }
     */
}
