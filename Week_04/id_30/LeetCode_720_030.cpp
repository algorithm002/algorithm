class Solution {
public:
    class Trie
	{
	public:
		Trie(vector<string>& words) : m_words(words)
		{
			m_root = new TrieNode(0);
			for (int i = 0; i < words.size(); ++i)
			{
				insert(words[i], i + 1);
			}
		}

		int getChildIndex(char c) { return c - 'a'; }

		void insert(string word, int i)
		{
			TrieNode* p = m_root;
			for (char c : word)
			{
				int index = getChildIndex(c);
				if (p->children[index] == nullptr)
				{
					p->children[index] = new TrieNode(c);
				}
				p = p->children[index];
			}
			p->end = i;
		}

		string bfs()
		{
			string resultWord;
			queue<TrieNode*> nodeQueue;
			nodeQueue.push(m_root);
			while (!nodeQueue.empty())
			{
				bool hasLongerWord = false;
				for(int nodeCount = nodeQueue.size(); nodeCount > 0; --nodeCount)
				{
					TrieNode* node = nodeQueue.front();
					nodeQueue.pop();
					if (node == m_root || node->end > 0)
					{
						if (!hasLongerWord && node->end > 0)
						{
							resultWord = m_words[node->end - 1];
							hasLongerWord = true;
						}
						for (TrieNode* child : node->children)
						{
							if(child)  nodeQueue.push(child);
						}
					}
				}
			}
			return resultWord;
		}

	private:
		static const int ChildrenSize = 26;
		class TrieNode
		{
		public:
			TrieNode(char cc) : c(cc), end(0)
			{
				for (int i = 0; i < ChildrenSize; ++i)  children[i] = nullptr;
			}
			char c;
			unsigned int end;
			TrieNode* children[ChildrenSize];
		};

		TrieNode* m_root;
		vector<string>& m_words;
	};

	string longestWord(vector<string>& words) {
		Trie trie(words);
		return trie.bfs();
	}
};