public class leetcode_211_42 {
}
public class WordDictionary {
    private final int SIZE = 26;
    private TrieNode root;

    class TrieNode {
        private TrieNode[] childs;
        private boolean isWord;
        private char val;

        TrieNode() {
            childs = new TrieNode[SIZE];
            isWord = false;
        }
    }

    public WordDictionary() {
        root = new TrieNode();
    }


    public void addWord(String word) {
        if (word == null & word.length() == 0) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (node.childs[index] == null) {
                TrieNode nodeNew = new TrieNode();
                nodeNew.val = chars[i];
                node.childs[index] = nodeNew;
            }
            node = node.childs[index];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return match(word, root, 0);
    }

    public boolean match(String word, TrieNode node, int start) {
        if (start == word.length()) {
            return node.isWord;
        }
        char alpha = word.charAt(start);
        if (alpha == '.') {
            for (int i = 0; i < 26; i++) {

                if ((node.childs[i] != null) && match(word, node.childs[i], start + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.childs[alpha - 'a'] == null)
                return false;
            return match(word, node.childs[alpha - 'a'], start + 1);

        }


    }
}
