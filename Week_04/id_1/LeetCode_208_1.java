class Trie {

    TrieNode root;
    class TrieNode{
        char val;
        TrieNode [] child=new TrieNode[26];
        boolean isWord=false;
        public TrieNode(){}
        public  TrieNode(char val){
            TrieNode node = new TrieNode();
            node.val=val;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            if(node.child[c-'a']==null){
                node.child[c-'a']=new TrieNode(c);
            }
            node=node.child[c-'a'];
        }
        node.isWord=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            if(node.child[c-'a']==null){
                return false;
            }
            node=node.child[c-'a'];
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = this.root;
        for (char c : prefix.toCharArray()) {
            if(node.child[c-'a']==null){
                return false;
            }
            node=node.child[c-'a'];

        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
