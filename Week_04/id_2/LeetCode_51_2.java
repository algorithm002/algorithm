//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//
//
//
// Given an integer n, return all distinct solutions to the n-queens puzzle.
//
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
// Example:
//
//
//Input: 4
//Output: [
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
//
//

package com.llz.algorithm.algorithm2019.fourthweek;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_51_2 {
    List<List<String>> list = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        for (int i = 0; i < queens.length; i++) {
            queens[i] = -1;
        }
        dfs(queens, 0, n);
        return list;
    }

    /**
     * My first solution
     * @param queens
     * @param row
     * @param maxRow
     */
    public void dfs(int[] queens, int row, int maxRow) {
        if (row == maxRow) {
            createList(queens, maxRow);
            return;
        } else {
            for (int col = 0; col < maxRow; col++) {
                if (isOK(queens, row, col, maxRow)) {
                    queens[row] = col;
                    dfs(queens, row + 1, maxRow);
                }
            }
        }
    }

    public boolean isOK(int[] queens, int row, int col, int maxRow) {
        int leftUp = col;
        int rightUp = col;
        for (int i = row - 1; i >= 0; i--) {
            if (queens[i] == col)
                return false;
            if (--leftUp >= 0 && leftUp == queens[i])
                return false;
            if (++rightUp < maxRow && rightUp == queens[i])
                return false;
        }
        return true;
    }

    public void createList(int[] queens, int maxRow) {
        List<String> innerList = new ArrayList<>();
        for (int i = 0; i < maxRow; i++) {
            StringBuilder sb = new StringBuilder();
            int col = queens[i];
            for (int j = 0; j < maxRow; j++) {
                if (j != col)
                    sb.append(".");
                else
                    sb.append("Q");
            }
            innerList.add(sb.toString());
        }
        list.add(innerList);
    }

    public void print(List<List<String>> temp) {
        int index = 1;
        for (List<String> tempInner : temp) {
            System.out.println(index++);
            System.out.println(tempInner);
        }
    }

    public static void main(String[] args) {
        LeetCode_51_2 l = new LeetCode_51_2();
        l.print(l.solveNQueens(8));
    }
}
