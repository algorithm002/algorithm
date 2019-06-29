class Solution
{
    class Trie
    {
    public:
        Trie *children[26]; // pointers to its substrings starting with 'a' to 'z'
        bool leaf;          // if the node is a leaf, or if there is a word stopping at here
        int idx;            // if it is a leaf, the string index of the array words
        Trie()
        {
            this->leaf = false;
            this->idx = 0;
            fill_n(this->children, 26, nullptr); // initialize children to 26 nullptr.
        }
    };

public:
    void insertWords(Trie *root, vector<string> &words, int idx)
    {
        int pos = 0, len = words[idx].size();
        while (pos < len)
        {
            if (nullptr == root->children[words[idx][pos] - 'a'])
                root->children[words[idx][pos] - 'a'] = new Trie();
            root = root->children[words[idx][pos++] - 'a'];
        }
        root->leaf = true;
        root->idx = idx;
    }

    Trie *buildTrie(vector<string> &words)
    {
        Trie *root = new Trie();
        for (int i = 0; i < words.size(); i++)
        {
            insertWords(root, words, i);
        }
        return root;
    }

    void checkWords(vector<vector<char>> &board, int i, int j, int row, int col, Trie *root, vector<string> &res, vector<string> &words)
    {
        char temp;
        vector<int> dx = {-1, 1, 0, 0};
        vector<int> dy = {0, 0, -1, 1};
        int x;
        int y;

        // terminator
        if (board[i][j] == 'X')
            return; // visited before;
        if (nullptr == root->children[board[i][j] - 'a'])
            return; // no string with such prefix
        else
        {
            // process current
            temp = board[i][j];
            if (root->children[temp - 'a']->leaf) // if it is a leaf
            {
                res.push_back(words[root->children[temp - 'a']->idx]);
                root->children[temp - 'a']->leaf = false; // set to false to indicate that we found it already
            }
            board[i][j] = 'X'; //mark the current position as visited, set flag temp = board[i][j]
                               // check all the possible neighbors
            // drill down
            x = i + dx[i];
            y = i + dy[i];
            for (int k = 0; k < 4; k++)
            {
                if (x >= 0 && x < row && y >= 0 && y < col && board[i][j] != 'X')
                    checkWords(board, x, y, row, col, root->children[temp - 'a'], res, words);
            }
            // recover
            board[i][j] = temp; // recover the current position
        }
    }

    vector<string> findWords(vector<vector<char>> &board, vector<string> &words)
    {
        vector<string> res;
        int row = board.size();
        if (0 == row)
            return res;
        int col = board[0].size();
        if (0 == col)
            return res;
        int wordCount = words.size();
        if (0 == wordCount)
            return res;

        Trie *root = buildTrie(words);

        int i, j;
        for (i = 0; i < row; i++)
        {
            for (j = 0; j < col && wordCount > res.size(); j++)
            {
                checkWords(board, i, j, row, col, root, res, words);
            }
        }
        return res;
    }
};