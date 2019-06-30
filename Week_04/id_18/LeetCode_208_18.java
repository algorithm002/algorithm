package Week_04.id_18;

/**
 * @author LiveForExperience
 * @date 2019/6/30 11:28
 */
public class LeetCode_208_18 {
    class Trie {
        private static final int SIZE = 26;
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (isEmpty(word)) {
                return;
            }

            char[] cs = word.toCharArray();
            TrieNode node = root;
            for (char c: cs) {
                int index = c - 'a';
                if (node.next[index] == null) {
                    node.next[index] = new TrieNode();
                    node.next[index].data = c;
                }
                node = node.next[index];
            }
            node.isWord = true;
        }

        public boolean search(String word) {
            if (isEmpty(word)) {
                return false;
            }

            char[] cs = word.toCharArray();
            TrieNode node = root;
            for (char c: cs) {
                int index = c - 'a';
                if (node.next[index] != null) {
                    node = node.next[index];
                } else {
                    return false;
                }
            }

            return node.isWord;
        }

        public boolean startsWith(String prefix) {
            if (isEmpty(prefix)) {
                return false;
            }

            TrieNode node = root;
            char[] cs = prefix.toCharArray();
            for (char c: cs) {
                int index = c - 'a';
                if (node.next[index] != null) {
                    node = node.next[index];
                } else {
                    return false;
                }
            }

            return true;
        }

        private boolean isEmpty(String word) {
            return word == null || word.length() == 0;
        }

        private class TrieNode {
            private char data;
            private TrieNode[] next;
            private boolean isWord;

            TrieNode() {
                this.next = new TrieNode[SIZE];
                this.isWord = false;
            }
        }
    }
}
