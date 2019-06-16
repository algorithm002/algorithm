public class Solution {
    public void MoveZeroes (int[] nums) {
        if (nums == null || nums.Length == 0 || nums.Length == 1) return;

        int count = 0;
        for (int i = 0; i < nums.Length; i++) {
            if (nums[i] != 0) {
                int temp = nums[count];
                nums[count] = nums[i];
                nums[i] = temp;
                count++;
            }
        }
    }
}