/*
 * @lc app=leetcode.cn id=66 lang=csharp
 *
 * [66] 加一
 *
 */
using System;

public class Solution {
    public int[] PlusOne (int[] digits) {
        for (int i = digits.Length - 1; i >= 0; i--) {
            if ((digits[i] + 1) % 10 != 0) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        digits = new int[digits.Length + 1];
        digits[0] = 1;
        return digits;
    }
}