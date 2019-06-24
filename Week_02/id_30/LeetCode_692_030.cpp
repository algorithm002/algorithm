class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        vector<string> topKFrequent(vector<string>& words, int k) {
        unordered_map<string, int> wordsFreqCountMap;
		for (const string& w : words)
		{
			++wordsFreqCountMap[w];
		}
		auto WordsComparer = [](const pair<string, int>& p1, const pair<string, int>& p2)
		{
			if (p1.second != p2.second)  return p1.second < p2.second;
			else                         return p1.first.compare(p2.first) > 0;
		};
		priority_queue<pair<string, int>, vector<pair<string, int>>, decltype(WordsComparer)> wordsQueue(wordsFreqCountMap.begin(), wordsFreqCountMap.end(), WordsComparer);
		vector<string> results;
		for (int i = 0; i < k; ++i)
		{
			results.push_back(wordsQueue.top().first);
			wordsQueue.pop();
		}
		return results;
    }
    }
};