class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int climbStairsHelper(int n, HashMap<Integer, Integer> map) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            map.put(n,climbStairs(n-2)+climbStairs(n-1));
            return climbStairs(n-2)+climbStairs(n-1);
        }
    }

    public int climbStairs(int n) {
        return climbStairsHelper(n, map);
    }
}