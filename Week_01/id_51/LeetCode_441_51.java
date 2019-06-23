class Solution {
    public int arrangeCoins(int n) {
        int left = 0;
        int right = n;
        int middle = middle(0, n);
        while ((left <= right) && !(formula(middle + 1) > n && formula(middle) < n)) {
            if (formula(middle + 1) < n) {
                left = middle;
            }
            if (formula(middle) > n) {
                right = middle;
            }
            if (formula(middle) == n) {
                return middle;
            }
            if (formula(middle + 1) == n) {
                return middle + 1;
            }
            middle = middle(left, right);
        }
        return middle;
    }

    private long formula(long n) {
        return n * (n + 1) / 2;
    }

    private int middle(int left, int right) {
        return left + (right - left) / 2;
    }
}
