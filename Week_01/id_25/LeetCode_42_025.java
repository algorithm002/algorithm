package highFrequencyLeetcode.leetcode_42;

import java.util.Stack;

/**
 * Hard
 * (注解文档查看快捷键 选中类名或方法名 按ctrl + Q)
 * <p>
 * 思维全过程记录方案：<p>
 * 1 背基础结构和算法      | 记录在课程笔记<p>
 * 2 看题 -> 悟题 思考过程 | 记录在wiki<p>
 * 3 悟题 -> 写题 实现难点 | 记录在代码注解<p>
 * 4 写题 -> 优化 多种解法 | 记录在leetcode提交
 * <p>
 * 问题：
 * Given n non-negative integers representing an elevation map
 * where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * <p>
 * 题解方案topics：
 * array、双指针、stack
 *
 * @author li tong
 * @date 2019/6/3 10:18
 * @see Object
 * @since 1.0
 */
public class LeetCode_42_025 {

    public static void main(String[] args) {
        int[] testcase = new int[]{2, 0, 2}; // 0, 2, 0
        System.out.println("FORCE=" + bruteForce(testcase));
        System.out.println();
        System.out.println("DP_ONE=" + dpOne(testcase));
        System.out.println();
        System.out.println("DP_TWO=" + dpTwo(testcase));
        System.out.println();
        System.out.println("STACK=" + stack(testcase));
    }

    /**
     * 解法1 暴力求解<p>
     *
     * @param columns
     * @return
     */
    public static int bruteForce(int[] columns) {
        int result = 0, length = columns.length;
        for (int i = 0; i < length; i++) {
            int maxl = 0, maxr = 0;
            for (int j = i; j < length; j++) {
                maxr = Math.max(maxr, columns[j]);
            }
            for (int j = i; j >= 0; j--) {
                maxl = Math.max(maxl, columns[j]);
            }
            result += Math.min(maxl, maxr) - columns[i];
        }
        return result;
    }

    /**
     * 解法2 DP求解<p>
     *
     * @param columns
     * @return
     */
    public static int dpOne(int[] columns) {
        if (columns.length == 0) {
            return 0;
        }
        int result = 0, length = columns.length;
        int[] maxl = new int[columns.length];
        int[] maxr = new int[columns.length];
        maxl[0] = columns[0];
        maxr[length - 1] = columns[length - 1];
        for (int i = 1; i < length; i++) {
            maxl[i] = Math.max(maxl[i - 1], columns[i]);
        }
        for (int i = length - 2; i >= 0; i--) {
            maxr[i] = Math.max(maxr[i + 1], columns[i]);
        }
        for (int i = 1; i < columns.length - 1; i++) {
            result += Math.min(maxl[i], maxr[i]) - columns[i];
        }
        return result;
    }

    /**
     * 解法3 DP求解 单次遍历<p>
     *
     * @param columns
     * @return
     */
    public static int dpTwo(int[] columns) {
        int result = 0, left = 0, right = columns.length - 1;
        int maxl = 0, maxr = 0;
        while (left < right) {
            if (columns[left] < columns[right]) {
                if (columns[left] >= maxl) {
                    maxl = columns[left];
                } else {
                    result += (maxl - columns[left]);
                }
                ++left;
            } else {
                if (columns[right] >= maxr) {
                    maxr = columns[right];
                } else {
                    result += (maxr - columns[right]);
                }
                --right;
            }
        }
        return result;
    }

    /**
     * 解法4 栈解法<p>
     *
     * @param columns
     * @return
     */
    public static int stack(int[] columns) {
        int result = 0, cursor = 0, length = columns.length;
        Stack<Integer> stack = new Stack<>();
        while (cursor < length) {
            if (stack.isEmpty() || columns[cursor] < columns[stack.peek()]) {
                stack.push(cursor++);
            } else {
                int bottom = stack.pop();
                if (stack.isEmpty()) {
                    continue;
                }
                int left = stack.peek();
                int square = (Math.min(columns[left], columns[cursor]) - columns[bottom]) * (cursor - left - 1);
                result += square;
            }
        }
        return result;
    }

}
