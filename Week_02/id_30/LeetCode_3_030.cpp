class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> lettersIndexMap;
        int startIndex = 0, endIndex = 0;
        int maxLength = 0;
        while(endIndex < s.size())
        {
            char c = s[endIndex];
            auto lettersIndexIter = lettersIndexMap.find(c);
            if (lettersIndexIter != lettersIndexMap.end())
            {
                maxLength = max(maxLength, endIndex - startIndex);
                int letterIndex = lettersIndexIter->second;
                if (letterIndex >= s.size() - maxLength - 1)  break;
                for (int j = startIndex; j <= letterIndex - 1; ++j)
                {
                    lettersIndexMap.erase(s[j]);
                }
                startIndex = letterIndex + 1;
            }
            lettersIndexMap[c] = endIndex;
            ++endIndex;
        }
        maxLength = max(maxLength, endIndex - startIndex);
        return maxLength;
    }
};