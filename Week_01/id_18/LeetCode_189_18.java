package Week_01.id_18;

/**
 * @author LiveForExperience
 * @date 2019/6/8 17:29
 */
public class LeetCode_189_18 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 0; i < k; i++) {
            doMove(nums);
        }
    }

    private void doMove(int[] nums) {
        int store = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            int tmp = store;
            store = nums[i + 1];
            nums[i + 1] = tmp;
        }
        nums[0] = store;
    }

    public void rotate1(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length <= 1 || (k % nums.length == 0)) {
            return;
        }


        int index = 0;
        int start = 0;
        int store = nums[index];
        for (int i = 0; i < nums.length; i++) {
            index = index + k >= nums.length ? (index + k) % nums.length: index + k;
            int tmpStore = store;
            store = nums[index];
            nums[index] = tmpStore;
            if (index == start) {
                start = ++index;
                store = nums[index];
            }
        }
    }

    public void rotate2(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length < 2 || k % nums.length == 0) {
            return;
        }

        k %= nums.length;

        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }

    private void swap(int[] nums, int head, int tail) {
        while (head < tail) {
            exchange(nums, head, tail);
            head++;
            tail--;
        }
    }

    private void exchange(int[] nums, int x, int y) {
        nums[x] ^= nums[y];
        nums[y] ^= nums[x];
        nums[x] ^= nums[y];
    }
}
