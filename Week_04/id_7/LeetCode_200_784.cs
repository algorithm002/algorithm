/*
 * @lc app=leetcode.cn id=784 lang=csharp
 *
 * [784] 字母大小写全排列
 */
using System.Collections.Generic;

public class Solution4 {
    // 方法1：BFS 不是自己想出来的，从国际版上讨论区学习到的
    // public IList<string> LetterCasePermutation (string S) {
    //     if (S == null) {
    //         return new List<string> ();
    //     }

    //     Queue<string> que = new Queue<string> ();
    //     que.Enqueue (S);

    //     for (int i = 0; i < S.Length; i++) {
    //         if (S[i] >= 48 && S[i] <= 57) continue;
    //         int size = que.Count;
    //         for (int j = 0; j < size; j++) {
    //             string cur = que.Dequeue ();
    //             // 先把自己加进去
    //             que.Enqueue (cur);

    //             char[] chs = cur.ToCharArray ();

    //             if (chs[i] >= 65 && chs[i] <= 90) {
    //                 // 原本大写的话，这里就转小写
    //                 chs[i] = char.ToLower (chs[i]);
    //                 que.Enqueue (new string (chs));
    //             } else {
    //                 // 否则转大写
    //                 chs[i] = char.ToUpper (chs[i]);
    //                 que.Enqueue (new string (chs));
    //             }
    //         }
    //     }

    //     return new List<string> (que);
    // }

    // 方法2：DFS 同样也不是自己想出来的
    public IList<string> LetterCasePermutation (string S) {
        if (S == null) {
            return new List<string> ();
        }
        List<string> lstRes = new List<string> ();
        dfs (S.ToCharArray (), lstRes, 0);

        return lstRes;
    }

    public void dfs (char[] chs, List<string> lst, int index) {
        if (index == chs.Length) {
            lst.Add (new string (chs));
            return;
        }

        if (chs[index] >= '0' && chs[index] <= '9') {
            dfs (chs, lst, index + 1);
            return;
        }

        chs[index] = char.ToLower (chs[index]);
        dfs (chs, lst, index + 1);

        chs[index] = char.ToUpper (chs[index]);
        dfs (chs, lst, index + 1);
    }
}