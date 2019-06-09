public class Solution {
    Dictionary<int, int> dic = new Dictionary<int, int> ();
    public int ClimbStairs (int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int A;
        if (dic.ContainsKey (n - 1)) {
            A = dic[n - 1];
        } else {
            A = ClimbStairs (n - 1);
            dic.Add (n - 1, A);
        }
        int B;
        if (dic.ContainsKey (n - 2)) {
            B = dic[n - 2];
        } else {
            B = ClimbStairs (n - 2);
            dic.Add (n - 2, B);
        }
        return A + B;
    }
}