public class leetcode_208_42 {
}

public class Trie {
    private final int SIZE = 26;
    private TrieNode root;

    class TrieNode {
        private TrieNode[] son;
        private boolean isWord;
        private char val;

        TrieNode() {
            son = new TrieNode[SIZE];
            isWord = false;
        }
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word.length() == 0) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            int pos = chars[i] - 'a';
            if (node.son[pos] == null) {
                node.son[pos] = new TrieNode();
                node.son[pos].val = chars[i];
            }
            node = node.son[pos];
        }

        node.isWord = true;
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            int pos = chars[i] - 'a';
            if (node.son[pos] == null) {
                return false;
            }
            if (node.son[pos].val != chars[i]) {
                return false;
            }
            node = node.son[pos];
        }

        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            int pos = chars[i] - 'a';
            if (node.son[pos].val != chars[i]) {
                return false;
            }
            node = node.son[pos];
        }

        return true;
    }

}