/*
 * @lc app=leetcode.cn id=703 lang=java
 *
 * [703] 数据流中的第K大元素
 */
class LeetCode_703_038 {
   
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{1, 2, 4, 9});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(0));
        System.out.println(kthLargest.add(8));
    }
}

/**
 * 优先队列
 */
class KthLargest {

    final PriorityQueue<Integer> pq;
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for(int i : nums) {
            add(i);
        }
    }
    
    public int add(int val) {
        if(pq.size() < k) {
            pq.offer(val);
        }else if(pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}