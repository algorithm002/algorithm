class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size())  return false;
        const int AlphabetSize = 26;
        int alphabetCount[AlphabetSize] = { 0 };
        for (int i = 0; i < s.size(); ++i)
        {
            ++alphabetCount[s[i] - 'a'];
            --alphabetCount[t[i] - 'a'];
        }
        for (int i = 0; i < AlphabetSize; ++i)
        {
            if (alphabetCount[i])  return false;
        }
        return true;
    }
};