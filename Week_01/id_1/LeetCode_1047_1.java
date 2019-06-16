package week01;

import java.util.Stack;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/6  12:41
 * @描述 LeetCode : 1047. 删除字符串中的所有相邻重复项     https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class RemoveAllAdjacent {
    public static void main(String[] args) {
        final RemoveAllAdjacent adjacent = new RemoveAllAdjacent();
        System.out.println(adjacent.removeDuplicates2("abbaca"));
    }

    /**
     * Method 1 :  使用堆栈 stack ;
     * 时间复杂度 ： O(N*K*K) ; 空间复杂度：O(N)
     */
    public String removeDuplicates(String S) {
        final Stack<Character> stack = new Stack<>();
        for (Character item : S.toCharArray()) {
            if (!stack.empty() && stack.peek() == item) {
                stack.pop();
            } else {
                stack.push(item);
            }
        }
        final StringBuilder builder = new StringBuilder();
        while (!stack.empty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    /**
     * Method 2 : 数组使用
     *  时间复杂度： O(S.length()) —> O(N)   ；   空间复杂度： O(S.length) —> O(N)
     */
    public String removeDuplicates2(String S) {
        final char[] chars = S.toCharArray();
        int top = 0;
        for (char c : chars) {
            if (top > 0 && chars[top - 1] == c) {
                top--;
                continue;
            }
            chars[top++] = c;
        }
        return new String(chars, 0, top);
    }


}
