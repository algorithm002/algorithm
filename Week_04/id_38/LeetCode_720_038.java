/*
 * @lc app=leetcode.cn id=720 lang=java
 *
 * [720] 词典中最长的单词
 */

class LeetCode_720_038 {

    public String longestWord(String[] words) {
        Set<String> s = new HashSet<>();
        for(String word : words)
            s.add(word);
        int ml = 0;
        String mw = "";
        for(String w : words){
            if(w.length() < ml) continue;
            if(w.length() == ml && w.compareTo(mw) >= 0) continue;
            int n = w.length();
            boolean flag = true;
            for(int i = 1; i < n; i++){
                if(!s.contains(w.substring(0, i))){
                    flag = false;
                    break;
                }   
            }
            if(flag){
                ml = w.length();
                mw = w;
            }    
        }
        
        return mw;
    }


    //#endregion
    private static final int R = 26;
    private TrieNode root;

    private static class TrieNode {
        private final TrieNode[] children;
        private String word;

        private TrieNode() {
            children = new TrieNode[R];
            word = null;
        }
    }

    private void insertWord(String word) {
        int len = word.length();
        TrieNode curr = root;
        char c;
        int idx;
        for (int i = 0; i < len; ++i) {
            c = word.charAt(i);
            idx = c - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }

        curr.word = word;
    }

    private String findLongestWord(TrieNode root) {
        String rst = root.word == null ? "" : root.word;
        for (TrieNode child : root.children) {
            if (child == null || child.word == null) continue;
            String s = findLongestWord(child);
            if (s.length() > rst.length()) rst = s;
        }
        return rst;
    }

    public String longestWord2(String[] words) {
        // initialize a new trie
        root = new TrieNode();

        // construct the trie based on input dictionary words
        for (String word : words) {
            insertWord(word);
        }

        // find the longest dictionary word in this trie according to given rules
        return findLongestWord(root);
    }
}
