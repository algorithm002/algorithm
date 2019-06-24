//Given a non-empty list of words, return the k most frequent elements.
// Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
//
// Example 1:
//
//Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//Output: ["i", "love"]
//Explanation: "i" and "love" are the two most frequent words.
//    Note that "i" comes before "love" due to a lower alphabetical order.
//
//
//
// Example 2:
//
//Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
//Output: ["the", "is", "sunny", "day"]
//Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
//    with the number of occurrence being 4, 3, 2 and 1 respectively.
//
//
//
// Note:
//
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Input words contain only lowercase letters.
//
//
//
// Follow up:
//
// Try to solve it in O(n log k) time and O(n) extra space.
//
//
package com.llz.algorithm.algorithm2019.secondweek;

import java.util.*;

public class LeetCode_692_2 {

    class WordNode implements Comparable<WordNode> {
        String word;
        int times;

        public WordNode(String word) {
            this.word = word;
            this.times = 1;
        }


        public int compareTo(WordNode o) {
            if (this.times > o.times)
                return -1;
            else if (this.times == o.times) {
                return this.word.compareTo(o.word);

            } else {
                return 1;
            }
        }
    }

    /**
     * Using priorityQueue, time complexity is O(nlogn)+O(n)+O(k) = O(n).
     * space complexity is O(n)
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        PriorityQueue<WordNode> pq = new PriorityQueue<>(k);
        HashMap<String, WordNode> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                WordNode wn = map.get(words[i]);
                wn.times++;
                map.put(words[i], wn);
            } else
                map.put(words[i], new WordNode(words[i]));
            WordNode w = map.get(words[i]);
        }

        Iterator<Map.Entry<String, WordNode>> lt = map.entrySet().iterator();
        while (lt.hasNext()) {
            pq.add(lt.next().getValue());
        }

        int j = 0;
        while (!pq.isEmpty()) {
            list.add(pq.poll().word);
            if (++j == k) break;
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode_692_2 l = new LeetCode_692_2();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(l.topKFrequent(words, 2));
    }
}
