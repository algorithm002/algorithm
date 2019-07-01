package week01;

import java.util.Arrays;

/**
 * Auth:luoxiang
 * Time:2019/6/30 5:54 PM
 * Desc:
 */
public class LeetCode_455_1 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_455_1().findContentChildren(new int[]{1,2},new int[]{1,2,3}));
        System.out.println(new LeetCode_455_1().findContentChildren(new int[]{1,2,3},new int[]{1,1}));
    }

    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) return 0;
        // g 与 s 排序
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int gi=0,si=0;
        while (gi<g.length && si<s.length){
            if(g[gi]<=s[si]){
                count++;
                gi++;si++;
            }else{
                si++;
            }
        }
        return count;
    }
}
