//Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.
//
// Example 1:
//
//Input:
//words = ["w","wo","wor","worl", "world"]
//Output: "world"
//Explanation:
//The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
//
//
//
// Example 2:
//
//Input:
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//Output: "apple"
//Explanation:
//Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
//
//
//
// Note:
// All the strings in the input will only contain lowercase letters.
// The length of words will be in the range [1, 1000].
// The length of words[i] will be in the range [1, 30].
//

package com.llz.algorithm.algorithm2019.fourthweek;

import java.util.Arrays;

/**
 * My original version. Use Arrays.sort(words[]) to know whether the current word
 * is built by the former word.
 */
class TrieTree {
    TrieNode root;

    public TrieTree() {
        this.root = new TrieNode(' ');
    }

    /**
     * Build word by last single character and return the length of the word.
     * If the word is not build by former word then return -1.
     * @param str word
     * @return length of the word
     */
    public int addWordBySingleChar(String str) {
        char[] charArray = str.toLowerCase().toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < charArray.length - 1; i++) {
            int index = charArray[i] - 'a';
            if (cur.childNodes[index] == null)
                return -1;
            else
                cur = cur.childNodes[index];

        }
        int targetIndex = charArray[charArray.length - 1] - 'a';
        cur.childNodes[targetIndex] = new TrieNode(charArray[charArray.length - 1]);
        cur.childNodes[targetIndex].nums = charArray.length;
        return charArray.length;
    }
}

class TrieNode {
    char c;
    TrieNode[] childNodes = new TrieNode[26];
    int nums;

    public TrieNode(char c) {
        this.c = c;
    }
}

public class LeetCode_720_2 {

    /**
     * Time complexity is O(nlogn)+O(Sum(wi)).
     * Because the method requires a sorted array (O(nlogn)).
     * Space complexity is O(Sum(wi)) as build trie tree for every word.
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        Arrays.sort(words);
        TrieTree trie = new TrieTree();
        int maxIndex = 0;
        int maxLength = 0;
        for (int i = 0; i < words.length; i++) {
            if (trie.addWordBySingleChar(words[i]) > maxLength) {
                maxIndex = i;
                maxLength = words[i].length();
            }
        }
        return words[maxIndex];
    }

    public static void main(String[] args) {
        LeetCode_720_2 l = new LeetCode_720_2();
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple", "az"};
        System.out.println(l.longestWord(words));
    }
}
