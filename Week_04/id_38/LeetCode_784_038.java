/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784] 字母大小写全排列
 */

class LeetCode_784_038 {
  public List<String> letterCasePermutation(String S) {
    List<String> ans = new ArrayList<>();
    StringBuilder root = new StringBuilder(S);
    dfs(ans, root, 0);
    return ans;
  }

  private void dfs(List<String> ans, StringBuilder root, int index) {
    if (index == root.length()) {
      ans.add(root.toString());
      return;
    }
    char c = root.charAt(index);
    if ('a' <= c && c <= 'z') {
      root.setCharAt(index, (char) (c - 32));
      dfs(ans, root, index + 1);
      root.setCharAt(index, c);
    } else if ('A' <= c && c <= 'Z') {
      root.setCharAt(index, (char) (c + 32));
      dfs(ans, root, index + 1);
      root.setCharAt(index, c);
    }
    dfs(ans, root, index + 1);
  }
}
