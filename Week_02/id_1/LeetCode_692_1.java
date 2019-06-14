package week02;


import java.util.*;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/12  9:30
 * @描述 LeetCode :  692. 前K个高频单词        https://leetcode-cn.com/problems/top-k-frequent-words/
 */
public class TopKFrequentWords692 {
    public static void main(String[] args) {


        String[] strs = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        String[] strs2 = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        final List<String> list = new TopKFrequentWords692().topKFrequent(strs, 2);
        final List<String> list2 = new TopKFrequentWords692().topKFrequent(strs2, 4);
        for (String s : list) {
            System.out.print(s + ",");
        }
        System.out.println();
        for (String s : list2) {
            System.out.print(s + ",");
        }

    }

    /**
     *  Method 1 : 使用优先队列， 需要重写 优先队列的比较方式
     *  时间复杂度 : O(N)    ;
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        PriorityQueue<String> pq = new PriorityQueue(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1) == map.get(o2) ? o1.compareTo(o2) : map.get(o2) - map.get(o1);
            }
        }
        );
        List<String> list = new LinkedList<>();
        for (String entry : map.keySet()) pq.offer(entry);
        for (int i = 0; i < k; i++) list.add(pq.poll());
        return list;
    }

    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
        );
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        List<String> list = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            list.add(pq.poll().getKey());
        }
        return list;
    }


}
