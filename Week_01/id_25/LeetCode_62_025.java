package highFrequencyLeetcode.leetcode_62;

/**
 * Medium
 * (注解文档查看快捷键 选中类名或方法名 按ctrl + Q)
 * <p>
 * 思维全过程记录方案：<p>
 * 1 背基础结构和算法      | 记录在课程笔记<p>
 * 2 看题 -> 悟题 思考过程 | 记录在wiki<p>
 * 3 悟题 -> 写题 实现难点 | 记录在代码注解<p>
 * 4 写题 -> 优化 多种解法 | 记录在leetcode提交
 * <p>
 * 问题：
 * A robot is located at the top-left corner of a m x n grid
 * (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid
 * (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 *  <p>
 * 题解方案topics：
 * array、dp
 *
 * @author li tong
 * @date 2019/6/4 11:36
 * @see Object
 * @since 1.0
 */
public class LeetCode_62_025 {

    /**
     * 观察时间复杂度
     */
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println(recursive(0, 0));
        System.out.println(recursive(1, 1));
        System.out.println(recursive(1, 2));
        System.out.println(recursive(2, 2));
        System.out.println(recursive(3, 2));
        System.out.println(recursive(3, 3));
        System.out.println("RECURSIVE=" + recursive(10, 10));
        System.out.println();

        System.out.println("RECURSIVE_MEM=" + recursiveMem(10, 10, new int[11][11]));
        System.out.println();

        System.out.println("TRY_DP_ONE=" + tryDPOne(10, 10));
        System.out.println();

        System.out.println("[LC PASS]DP_ONE=" + dpOne(51, 9));
        System.out.println();

        System.out.println("[LC PASS]DP_TWO=" + dpTwo(10, 10));
        System.out.println();

        System.out.println("[LC PASS]MATH=" + math(23, 12));
        System.out.println("Count=" + count);
    }

    /**
     * 解法1 递归<p>
     *
     * @param m 棋盘长度
     * @param n 棋盘高度
     * @return
     */
    public static int recursive(int m, int n) {
        count++;
        if (m < 1 || n < 1) {
            return 0;
        } else if (m == 1 || n == 1) {
            return 1;
        }
        return recursive(m - 1, n) + recursive(m, n - 1);
    }

    /**
     * 解法2 缓存递归<p>
     *
     * @param m
     * @param n
     * @param mem
     * @return
     */
    public static int recursiveMem(int m, int n, int[][] mem) {
        count++;
        if (m < 1 || n < 1) {
            return 0;
        } else if (m == 1 || n == 1) {
            return 1;
        } else if (mem[m][n] == 0) {
            mem[m][n] = recursiveMem(m - 1, n, mem) + recursiveMem(m, n - 1, mem);
        }
        return mem[m][n];
    }

    /**
     * 解法3 DP
     *
     * @param m
     * @param n
     * @return
     */
    public static int dpOne(int m, int n) {
        count++;
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 解法4 DP优化
     *
     * @param m
     * @param n
     * @return
     */
    public static int dpTwo(int m, int n) {
        count++;
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

    /**
     * 解法5 数学解法
     * <p>
     * 公式 C(4, 3) = A(4,3)/ A(3,3) = 4*3*2 / 3*2*1 = 4<p>
     * 证明 abcd => abc abd acd bcd<p>
     * 公式 C(4, 2) = 4 * 3 / 2 = 6<p>
     * 证明 abcd => ab ac ad bc bd cd<p>
     * <p>
     * 证明 C5,3 = C5,5-3 = C5,2<p>
     * abcde<p>
     * C53 = abc abd abe acd ace ade + C43 = 10<p>
     * C52 = 5*4/2 = 10<p>
     * <p>
     * n > k<p>
     * C(n, k) = A(n,k) / A(k,k) = C(n, n-k) = A(n,n-k)  / A(n-k,n-k)<p>
     * C52     = 5 * 4  / 2!     = C53       = 5 * 4 * 3 / 3!<p>
     * = (n * n-1 * n-2 ... * n - k + 1) / k!<p>
     *
     * @param m
     * @param n
     * @return
     */
    public static int math(int m, int n) {
        // 总步数
        int t = n + m - 2;
        // 单单往下(或往右)的步数
        int k = m - 1;
        double res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (t - k + i) / i;
        }
        return (int)res;
    }

}
