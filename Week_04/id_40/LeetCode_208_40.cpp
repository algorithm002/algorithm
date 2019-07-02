/*
 * @lc app=leetcode id=208 lang=cpp
 *
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (39.02%)
 * Likes:    1640
 * Dislikes: 34
 * Total Accepted:    184.5K
 * Total Submissions: 472.8K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 * 
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");   
 * trie.search("app");     // returns true
 * 
 * 
 * Note:
 * 
 * 
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 * 
 * 
 */
const int MAXN = 26;
class Trie {
public:
    /** Initialize your data structure here. */
    bool is_str; // 标识当前结点是否为一个完整的字符串
    Trie *next[MAXN]; // 下一个结点的指针数组
    Trie() {
        is_str = NULL;
        memset(next,0,sizeof(next));
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
          Trie *cur = this; // cur初始化为根结点指针
        for(char w : word){ // 遍历word中的每一个字符
            if(cur->next[w-'a']==NULL){ // 下一个结点不存在，新增一个结点
                Trie *new_node = new Trie();
                cur->next[w-'a'] = new_node;
            }
            cur = cur->next[w-'a'];
        }
        cur->is_str = true; // 当前结点已经是一个完整的字符串了

       
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
         Trie *cur = this;
        for(char w : word){
            if(cur!=NULL)
                cur = cur->next[w-'a']; // 更新cur指针的指向，使其指向下一个结点
        }
        return (cur!=NULL&&cur->is_str); // cur指针不为空且cur指针指向的结点为一个完整的字符串，则成功找到字符串
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie *cur = this;
        for(char w : prefix){
            if(cur!=NULL)
                cur = cur->next[w-'a'];
        }
        return (cur!=NULL); // 相比search(),这里只需判断cur指针是否为空就行了
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */

