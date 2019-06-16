class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            if (map.containsKey(temp)) {
                if (map.get(temp) != i) {
                    result[0] = i;
                    result[1] = map.get(temp);
                }
            } else {
                map.put(target - temp, i);
            }
        }
        return result;
    }
}
