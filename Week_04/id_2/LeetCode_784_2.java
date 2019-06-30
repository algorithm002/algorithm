//Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string. Return a list of all possible strings we could create.
//
//
//Examples:
//Input: S = "a1b2"
//Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
//
//Input: S = "3z4"
//Output: ["3z4", "3Z4"]
//
//Input: S = "12345"
//Output: ["12345"]
//
//
// Note:
//
//
// S will be a string with length between 1 and 12.
// S will consist only of letters or digits.
//
//

package com.llz.algorithm.algorithm2019.fourthweek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_784_2 {

    private List<String> list = new ArrayList<>();

    /**
     * My first method using backtrack.
     *
     * @param S
     * @return
     */
    public List<String> letterCasePermutation(String S) {
        char[] chars = S.toCharArray();
        backTrack(chars, 0);
        return list;
    }

    /**
     * The time and space complexity is O(2^n)
     *
     * @param chars
     * @param index
     */
    public void backTrack(char[] chars, int index) {
        if (index > chars.length - 1) {
            list.add(String.valueOf(chars));
            return;
        }
        if (chars[index] > 57) { //letter
            backTrack(chars, index + 1); // no change
            chars[index] = chars[index] < 91 ? Character.toLowerCase(chars[index]) : Character.toUpperCase(chars[index]);
            backTrack(chars, index + 1); // change
        } else
            backTrack(chars, index + 1); // number
    }

    /**
     * Using BFS.
     * @param S
     * @return
     */
    public List<String> letterCasePermutationByBFS(String S) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        for (int j = 0; j < S.length(); j++) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String sTemp = queue.poll();
                char[] chars = sTemp.toCharArray();
                if (Character.isDigit(chars[j])) {
                    queue.offer(String.valueOf(chars));
                    continue;
                }
                chars[j] = Character.toUpperCase(chars[j]);
                queue.offer(String.valueOf(chars));
                chars[j] = Character.toLowerCase(chars[j]);
                queue.offer(String.valueOf(chars));
            }
        }
        return new LinkedList<>(queue);
    }

    public void print(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        String S = "a1b2";
        LeetCode_784_2 l = new LeetCode_784_2();
        l.print(l.letterCasePermutationByBFS(S));
    }
}
