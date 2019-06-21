package Week_03.id_18;

import java.util.*;

/**
 * @author LiveForExperience
 * @date 2019/6/20 12:23
 */
public class LeetCode_295_18 {
    private int count;
    private Queue<Integer> maxHeap;
    private Queue<Integer> minHeap;

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

    private List<Integer> list = new ArrayList<>();

    public void addNum1(int num) {
        if (list.isEmpty()) {
            list.add(num);
            return;
        }

        int left = 0, right = list.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2, val = list.get(mid);
            if (num < val) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (list.get(list.size() - 1) < num) {
            list.add(num);
        } else {
            list.add(left, num);
        }
    }

    public double findMedian1() {
        int len = list.size(),  midNum = len / 2;
        return (len & 1) == 0 ? ((double) list.get(midNum - 1) + (double) list.get(midNum)) / 2 : list.get(midNum);
    }
}
