package week01;

import java.util.Stack;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/6  18:00
 * @描述 LeetCode : 1021. 删除最外层的括号    https://leetcode-cn.com/problems/remove-outermost-parentheses/
 */
public class RemoveOuterMostParenteses {

    public static void main(String[] args) {
        String str = "(()())(())";
        String str2 = "(()())(())(()(()))";
        String str3 = "()()";
        System.out.println(new RemoveOuterMostParenteses().removeOuterParentheses2(str));
        System.out.println(new RemoveOuterMostParenteses().removeOuterParentheses2(str2));
        System.out.println(new RemoveOuterMostParenteses().removeOuterParentheses2(str3));
    }

    /**
     * Method 1 ： 使用 stack 来进行操作 。
     * ( 先判空,非空 则加入字符串中，在push;
     * ) 先pop,再判空，非空则加入 字符串中;
     * 时间复杂度 ： O(N)  ;    空间复杂度 ： O(N)
     */
    public String removeOuterParentheses(String S) {
        final Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (!stack.empty()) sb.append(c);
                stack.push(c);
            } else {
                stack.pop();
                if (!stack.empty()) sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Method 2 :   用一个计数器 count 来保存； （ count++ ; ) count-- ;
     *  时间复杂度 ： O(N)    ;   空间复杂度 : O(1)
     */
    public String removeOuterParentheses2(String S) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                count++;
                if (count > 1) sb.append(c);
            } else {
                count--;
                if (count != 0) sb.append(c);
            }
        }
        return sb.toString();
    }

}
