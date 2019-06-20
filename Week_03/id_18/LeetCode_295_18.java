package Week_03.id_18;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author LiveForExperience
 * @date 2019/6/20 12:23
 */
public class LeetCode_295_18 {
    private int count;
    private Queue<Integer> maxHeap;
    private Queue<Integer> minHeap;
    /** initialize your data structure here. */
    public LeetCode_295_18() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count++;
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if ((count & 1) == 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        return (count & 1) == 0 ? (new Double(maxHeap.peek()) + new Double(minHeap.peek())) / 2 : maxHeap.peek();
    }

    public static void main(String[] args) {
        LeetCode_295_18 test = new LeetCode_295_18();
        test.addNum(1);
        test.addNum(2);
        test.addNum(3);
        System.out.println(test.findMedian());
    }
}
