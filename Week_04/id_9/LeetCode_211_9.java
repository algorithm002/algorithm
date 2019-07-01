package com.github.lifelab.leetcode.problemset;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * 添加与搜索单词 - 数据结构设计 @see https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/
 *
 * @author Weichao Li (liweichao0102@gmail.com)
 * @since 2019-06-30
 */
public class Solution211 {

    /**
     * hash + cache 实现
     */
    public class WordDictionary1 {

        private Map<String, String> wd;

        private Map<String, Boolean> cache;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary1() {
            this.wd = new HashMap<>();
            this.cache = new HashMap<>();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            wd.put(word, word);
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            Boolean cacheValue = cache.get(word);
            if (Objects.nonNull(cacheValue) && cacheValue) {
                return cacheValue;
            } else {
                cacheValue = wd.keySet().parallelStream().anyMatch(e -> Pattern.matches(word, e));
                cache.put(word, cacheValue);
            }
            return cacheValue;
        }

    }

    /**
     * tree 实现
     */
    public class WordDictionary2 {

        class Node {

            private Node[] next;

            private boolean isWord;

            public Node() {
                next = new Node[26];
                isWord = false;
            }
        }

        private Node root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary2() {
            root = new Node();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            int len = word.length();
            Node curNode = root;
            for (int i = 0; i < len; i++) {
                char curChar = word.charAt(i);
                Node next = curNode.next[curChar - 'a'];
                if (next == null) {
                    curNode.next[curChar - 'a'] = new Node();
                }
                curNode = curNode.next[curChar - 'a'];
            }
            if (!curNode.isWord) {
                curNode.isWord = true;
            }
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return match(word, root, 0);
        }

        private boolean match(String word, Node node, int start) {
            if (start == word.length()) {
                return node.isWord;
            }
            char alpha = word.charAt(start);
            if (alpha == '.') {
                for (int i = 0; i < 26; i++) {
                    if (node.next[i] != null && match(word, node.next[i], start + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (node.next[alpha - 'a'] == null) {
                    return false;

                }
                return match(word, node.next[alpha - 'a'], start + 1);
            }
        }
    }

}