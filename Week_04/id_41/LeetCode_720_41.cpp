/*
 * @lc app=leetcode id=720 lang=cpp
 *
 * [720] Longest Word in Dictionary
 * Trie + DFS
 * T(n) = O(key_length)
 * S(n) = O(26 * key_length *N)
 */

class TrieNode
{
public:
    char data;
    vector<TrieNode *> children;
    bool isEndingChar;
    TrieNode(char c) : data(c), children(26, nullptr), isEndingChar(false)
    {
    }
    ~TrieNode()
    {
        for (TrieNode *child : children)
        {
            if (child)
                delete child;
        }
    }
};

class Trie
{
public:
    void insert(string s)
    {
        TrieNode *p = root;
        for (auto c : s)
        {
            int index = c - 'a';
            if (p->children[index] == nullptr)
            {
                TrieNode *newNode = new TrieNode(c);
                p->children[index] = newNode;
            }
            p = p->children[index];
        }
        p->isEndingChar = true;
    }

    bool find(string pattern)
    {
        TrieNode *p = root;
        for (auto c : pattern)
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

    bool startsWith(string pattern)
    {
        TrieNode *p = root;
        for (auto c : pattern)
        {
            int index = c - 'a';
            if (p->children[index] == nullptr)
                return false;
            p = p->children[index];
        }
        return true;
    }
    TrieNode *root = new TrieNode(' ');
};

class Solution
{
public:
    string longestWord(vector<string> &words)
    {
        if (words.size() == 0)
            return res;
        Trie *trieTree = buildTrie(words);
        dfs(trieTree->root, "");

        return res;
    }

private:
    Trie *buildTrie(vector<string> &words)
    {
        Trie *t = new Trie();
        for (string w : words)
        {
            t->insert(w);
        }
        return t;
    }

    void dfs(TrieNode *root, string curr)
    {
        if (root == nullptr)
            return;
        for (int i = 0; i < 26; i++)
        {
            if (root->children[i] != nullptr &&
                root->children[i]->isEndingChar == true)
            {
                curr.append(1, i + 'a');
                if (curr.size() > res.size())
                    res = curr;
                dfs(root->children[i], curr);
                curr.pop_back();
            }
        }
    }

    string res = "";
};
