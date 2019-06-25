package Week_04.id_18;

import java.util.*;

/**
 * @author LiveForExperience
 * @date 2019/6/24 21:25
 */
public class LeetCode_720_18 {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String result = "";
        Set<String> set = new HashSet<>();
        for (String word: words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                result = word.length() > result.length() ? word : result;
            }
        }
        return result;
    }

    public String longestWord1(String[] words) {
        TrieTree trieTree = new TrieTree();
        for (String word: words) {
            trieTree.insert(word);
        }

        String result = "";
        int len = 0;

        for (String word: words) {
            if (trieTree.isBuild(word) && word.length() > len) {
                result = word;
                len = result.length();
            } else if (trieTree.isBuild(word) && word.length() == len) {
                char[] wordCs = word.toCharArray();
                char[] resultCs = result.toCharArray();
                for (int i = 0; i < len; i++) {
                    if (wordCs[i] < resultCs[i]) {
                        result = word;
                        break;
                    } else if (wordCs[i] > resultCs[i]) {
                        break;
                    }
                }
            }
        }

        return result;
    }

    private class TrieTreeNode {
        private char data;
        private boolean isWord;
        private TrieTreeNode[] next;

        public TrieTreeNode(char data) {
            this.data = data;
            this.next = new TrieTreeNode[26];
        }
    }

    private class TrieTree {
        TrieTreeNode root = new TrieTreeNode('/');
        public void insert(String word) {
            char[] cs = word.toCharArray();
            TrieTreeNode node = root;
            for (char c: cs) {
                int index = c - 'a';
                if (node.next[index] == null) {
                    node.next[index] = new TrieTreeNode(c);
                }
                node = node.next[index];
            }

            node.isWord = true;
        }

        public boolean isBuild(String word) {
            char[] cs = word.toCharArray();
            TrieTreeNode node = root;
            for (char c: cs) {
                int index = c - 'a';
                if (!node.next[index].isWord) {
                    return false;
                }
                node = node.next[index];
            }
            return true;
        }
    }
}
