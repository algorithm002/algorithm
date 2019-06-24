package Week_01.id_18;

/**
 * @author LiveForExperience
 * @date 2019/6/6 13:30
 */
public class LeetCode_441_18 {
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(n * 2.0 + 0.25) - 0.5);
    }

    public int arrangeCoins1(int n) {
        int c = 0;
        while(c < n) {
            n -= ++c;
        }
        return c;
    }
}
