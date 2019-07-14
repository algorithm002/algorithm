class Solution {
    private static final int R=26;
    private TrieNode root;
    
    private class TrieNode {
        TrieNode[] children;
        String word;
        
        public TrieNode() {
            children = new TrieNode[R];
            word = null;
        } 
    }
    
    public void insertWord(String word) {
        int len = word.length();
        TrieNode curr = root;
        int index;
        char c;
        for(int i=0;i<len;++i) {
            c = word.charAt(i);
            index = c - 'a';
            
            if(curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            
            curr = curr.children[index];
        }
        curr.word = word;
    }
    
    public String findLongestWord(TrieNode root) {
        String res = root == null ? "" :root.word;
        int len = 0;
        for(int i=0;i<26;++i) {
            if(root.children[i] == null || root.children[i].word == null) continue;
            String s = findLongestWord(root.children[i]);
            if(s == null) continue;
            if(s.length() > len) {
                res = s;
                len = s.length();
            }
                
        }
        
        return res;
    }
    
    public String longestWord(String[] words) {
        root = new TrieNode();
        
        for(String word : words) {
            insertWord(word);
        }
        
        return findLongestWord(root);
    }
}