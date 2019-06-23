/*
 * @lc app=leetcode id=703 lang=java
 *
 * [703] Kth Largest Element in a Stream
 */
class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (Integer n : nums) {
            minHeap.add(n);
            if(minHeap.size()>k)
                minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size() > k)
            minHeap.poll();
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

