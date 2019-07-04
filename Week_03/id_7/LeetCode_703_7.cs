/*
 * @lc app=leetcode.cn id=703 lang=csharp
 *
 * [703] 数据流中的第K大元素
 */
using System;

public class KthLargest {
    int[] heap;
    // 堆中已经存储的数据个数
    int count;
    // 堆容量
    int capacity;

    public KthLargest (int k, int[] nums) {
        heap = new int[k];
        capacity = k;
        count = 0;
        for (int i = 0; i < nums.Length; i++) {
            Add (nums[i]);
        }
    }

    public int Add (int val) {
        if (count < capacity) {
            heap[count] = val;
            int i = count;
            while (i > 0) {
                int nPIndex = (i - 1) / 2;
                if (heap[i] < heap[nPIndex]) {
                    int temp = heap[i];
                    heap[i] = heap[nPIndex];
                    heap[nPIndex] = temp;
                }
                i = nPIndex;
            }
            count++;
        } else if (val > heap[0]) {
            heap[0] = val;
            int i = 0;
            while (i * 2 + 1 < count) {
                i = i * 2 + 1;
                if (i + 1 < count && heap[i] > heap[i + 1]) {
                    i++;
                }
                int nPIndex = (i - 1) / 2;
                if (heap[nPIndex] > heap[i]) {
                    int temp = heap[nPIndex];
                    heap[nPIndex] = heap[i];
                    heap[i] = temp;
                }
            }
        }

        return heap[0];
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.Add(val);
 */