/*
 * @lc app=leetcode.cn id=295 lang=csharp
 *
 * [295] 数据流的中位数
 */
using System.Collections.Generic;

// 方法1：暴力法，每插入一个数，就排序整个序列，一般排序时间复杂度为O(nlogn)，取中位数为O(1)，所以总的来说是O(nlogn)
// 这里就不写了，实测提交会超时

// 方法2：使用插入排序，插入排序的时间复杂度为O(logn)，需要添加的n个数的话，遍历造成的时间复杂度为O(n)，所以总的来说是O(n)
// public class MedianFinder1 {

//     private List<int> m_lst;
//     /** initialize your data structure here. */
//     public MedianFinder1 () {
//         m_lst = new List<int> ();
//     }

//     public void AddNum (int num) {
//         if (m_lst.Count == 0) {
//             m_lst.Add (num);
//             return;
//         }
//         m_lst.Insert (GetMedianIndex (0, m_lst.Count, num), num);
//     }

//     public int GetMedianIndex (int start, int end, int num) {
//         if (start == end) {
//             return start;
//         }
//         int mid = (end - start) / 2 + start;
//         if (m_lst[mid] > num) {
//             return GetMedianIndex (start, mid, num);
//         } else if (m_lst[mid] < num) {
//             return GetMedianIndex (mid + 1, end, num);
//         } else {
//             return mid;
//         }
//     }

//     public double FindMedian () {
//         if (m_lst.Count == 1) {
//             return m_lst[0];
//         }
//         if (m_lst.Count % 2 == 1) {
//             return m_lst[m_lst.Count / 2];
//         } else {
//             return (double) (m_lst[m_lst.Count / 2 - 1] + m_lst[m_lst.Count / 2]) / 2;
//         }
//     }
// }

// 方法3：两个优先队列（自己使用sortedlist实现，效率不如二分法），一个降序，一个升序
public class MedianFinder {

    PriorityQueue pqo = new PriorityQueue (true);
    PriorityQueue pqi = new PriorityQueue ();

    /** initialize your data structure here. */
    public MedianFinder () { }

    public void AddNum (int num) {
        pqo.Enqueue (num);

        pqi.Enqueue (pqo.Dequeue ());

        if (pqo.Size () < pqi.Size ()) {
            pqo.Enqueue (pqi.Dequeue ());
        }
    }

    public double FindMedian () {
        return pqo.Size () > pqi.Size () ? (double) pqo.Top () : (pqo.Top () + pqi.Top ()) * 0.5;
    }
}

class DescendedDateComparer : IComparer<int> {
    public int Compare (int x, int y) {
        // use the default comparer to do the original comparison for int
        int ascendingResult = Comparer<int>.Default.Compare (x, y);

        // turn the result around
        return 0 - ascendingResult;
    }
}

public class PriorityQueue {
    private SortedList<int, int> m_sortedlst;
    private int m_nCount;

    public PriorityQueue (bool blDescending = false) {
        if (blDescending) {
            m_sortedlst = new SortedList<int, int> (new DescendedDateComparer ());
        } else {
            m_sortedlst = new SortedList<int, int> ();
        }
        m_nCount = 0;
    }

    public void Enqueue (int num) {
        if (m_sortedlst.ContainsKey (num)) {
            m_sortedlst[num]++;
        } else {
            m_sortedlst.Add (num, 1);
        }
        m_nCount++;
    }

    public int Dequeue () {

        if (m_nCount == 0) {
            return 0;
        }

        int ans = m_sortedlst.Keys[0];

        if (m_sortedlst.GetValueOrDefault (ans) > 1) {
            m_sortedlst[ans] = m_sortedlst.Values[0] - 1;
        } else {
            m_sortedlst.Remove (ans);
        }

        m_nCount--;

        return ans;
    }

    public int Top () {
        if (m_nCount == 0) {
            return 0;
        }

        return m_sortedlst.Keys[0];
    }

    public int Size () {
        return m_nCount;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.AddNum(num);
 * double param_2 = obj.FindMedian();
 */