/*
 * @lc app=leetcode.cn id=703 lang=csharp
 *
 * [703] 数据流中的第K大元素
 */
using System;

public class KthLargest {
    int[] heap;
    int count;
    int capacity;

    public KthLargest (int k, int[] nums) {
        heap = new int[nums.Length];
        capacity = k;
        count = 0;
        for (int i = 0; i < nums.Length; i++) {
            Add (nums[i]);
        }
    }

    public int Add (int val) {
        if (count < capacity) {
            heap[count++] = val;
            int i = count - 1;
            while (i > 0) {
                if (heap[i] < heap[(i - 1) / 2]) {
                    int temp = heap[i];
                    heap[i] = heap[(i - 1) / 2];
                    heap[(i - 1) / 2] = temp;
                }
                i = (i - 1) / 2;
            }
        } else if (val > heap[0]) {
            heap[0] = val;
            int i = 0;
            while (i * 2 + 1 < count) {
                i = i * 2 + 1;
                if (i + 1 < count && heap[i] > heap[i + 1]) {
                    i++;
                }
                if (heap[(i - 1) / 2] > heap[i]) {
                    int temp = heap[(i - 1) / 2];
                    heap[(i - 1) / 2] = heap[i];
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