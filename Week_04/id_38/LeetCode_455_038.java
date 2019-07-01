/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */
class LeetCode_455_038 {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int count = 0;
    int i = 0, j = 0;
    while (i < g.length && j < s.length) {
      if (g[i] <= s[j]) {
        i++;
        j++;
        count++;
      } else {
        j++;
      }
    }
    return count;
  }

  public int findContentChildren2(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int i = 0, j = 0;
    int l1 = g.length, l2 = s.length;
    while (i < l1 && j < l2) {
      if (g[i] <= s[j]) {
        i++;
      }
      j++;
    }
    return i;
  }
}
