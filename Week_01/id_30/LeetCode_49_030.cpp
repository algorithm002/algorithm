class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> anagramGroups;
		for (string s : strs)
		{
			string originStr = s;
			sort(s.begin(), s.end());
			anagramGroups[s].push_back(originStr);
		}
		vector<vector<string>> results;
		for (const pair<string, vector<string>>& strPair : anagramGroups)
		{
			results.push_back(strPair.second);
		}
		return results;
    }
};