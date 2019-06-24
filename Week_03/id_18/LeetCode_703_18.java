package Week_03.id_18;

import java.util.*;

/**
 * @author LiveForExperience
 * @date 2019/6/17 12:32
 */
public class LeetCode_703_18 {
    private Queue<Integer> queue;
    private int k;

    public LeetCode_703_18(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);
        for (int num: nums) {
            offer(num);
        }
    }

    public int add(int val) {
        offer(val);
        return this.queue.peek();
    }

    private void offer(int num) {
        if (this.queue.size() < this.k) {
            this.queue.offer(num);
        } else if (this.queue.peek() < num) {
            this.queue.poll();
            this.queue.offer(num);
        }
    }
}
