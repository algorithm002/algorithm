
package week01;

/**
 *  LeetCode : 441. 排列硬币    https://leetcode-cn.com/problems/arranging-coins/
 */

public class ArrangingCoins {

    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().arrangeCoins2(5));
        System.out.println(new ArrangingCoins().arrangeCoins2(8));
        System.out.println(new ArrangingCoins().arrangeCoins2(10));
        System.out.println(new ArrangingCoins().arrangeCoins2(14));
        System.out.println(new ArrangingCoins().arrangeCoins2(16));
    }

    /**
     *
     * Method 1 :  循环递减 count ;
     *  时间复杂度 ： O(logN) ;   空间复杂度 ： O(1)    ;
     */
    public int arrangeCoins(int n) {
        if(n==0){
            return 0;
        }
        int count=1;
        while(n>0){
            n-=count;
            if(n>count){
                count++;
            }
        }
        return count;
    }

    /**
     *
     * Method 2 : 纯数学题解法 ； 推导递推公式
     */
    public int arrangeCoins2(int n){
        return (int)(Math.sqrt(2*(long)n+0.25)-0.5);
    }
    /**
     *
     * Method 3 : 纯数学题解法 ； 演变形式 ——> 推导递推公式
     */

    public int arrangeCoins3(int n){
        return (int)((Math.sqrt(8*n+1)-1)/2);
    }
}
