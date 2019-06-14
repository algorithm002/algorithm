package week02;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/12  16:04
 * @描述 LeetCode : 726. 原子的数量       https://leetcode-cn.com/problems/number-of-atoms/
 */
public class NumberOfAtoms726 {
    public static void main(String[] args) {
        String str = "Mg(OH)2";
        String str2 = "K4(ON(SO3)2)2";
        new NumberOfAtoms726().countOfAtoms(str);
        new NumberOfAtoms726().countOfAtoms(str2);
    }

    /**
     *  思考方式简单，实现比较麻烦
     *  Method 1 :  使用 堆栈 + map 解决
     *      拆解为三种情况：
     *          1、 (    左括号，压栈
     *          2、  )   右括号，出栈
     *          3、 字符串
     *              判断是否为 小写
     *              判断是否为 数字
     *  时间复杂度 : O(N)    ;
     *  空间复杂度 : O(N)    ;
     */
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());

        for (int i = 0; i < n; ) {
            if (formula.charAt(i) == '(') {
                stack.push(new TreeMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop();
                int start = ++i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multi = (i == start ? 1 : Integer.parseInt(formula.substring(start, i)));
                for (String s : top.keySet()) {
                    Integer sum = top.get(s);
                    stack.peek().put(s, stack.peek().getOrDefault(s, 0) + sum * multi);
                }
            } else {
                int start = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String key = formula.substring(start, i);
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multi = (i == start ? 1 : Integer.parseInt(formula.substring(start, i)));
                // 当前 括号 内可能有重复的元素
                stack.peek().put(key, stack.peek().getOrDefault(key, 0) + multi);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack.peek().keySet()) {
            Integer num = stack.peek().get(s);
            sb.append(s);
            if (num > 1) sb.append(num);
        }
        return sb.toString();
    }
}
