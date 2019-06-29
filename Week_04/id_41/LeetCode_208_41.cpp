/*
 * @lc app=leetcode id=208 lang=cpp
 *
 * [208] Implement Trie (Prefix Tree)
 */
class TrieNode {
public:
    char data;
    vector<TrieNode*> children;
    bool isEndingChar;
    TrieNode(char c) : data(c), children(26, nullptr), isEndingChar(false)
    {
    }
    ~TrieNode()
    {
        for (auto child : children)
        {
            if (child)
                delete child;
        }
    }
};

class Trie {
public:
    /** Initialize your data structure here. */
    Trie() {
        root = new TrieNode(' ');
    }
    ~Trie() {
        delete root;
    }
    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode* p = root;
        for (auto c : word)
        {
            int index = c - 'a';
            if (p->children[index] == nullptr)
            {
                p->children[index] = new TrieNode(c);
            }
            p = p->children[index];
        }
        p->isEndingChar = true;
    }

    /** Returns if the word is in the trie. */
    bool search(string word) {
        TrieNode* p = root;
        for (auto c : word)
        {
            int index = c - 'a';
            if (p->children[index] == nullptr)
            {
                return false;
            }
            p = p->children[index];
        }
        return p->isEndingChar;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        TrieNode *p = root;
        for (auto c : prefix)
        {
            int index = c - 'a';
            if (p->children[index] == nullptr)
            {
                return false;
            }
            p = p->children[index];
        }
        return true;
    }

private:
    TrieNode* root;
};
