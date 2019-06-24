/*
 * @lc app=leetcode id=127 lang=cpp
 *
 * [127] Word Ladder
 * T(n) = O(word_count * num_char_in_word)
 */
class Solution
{
public:
    int ladderLength(string beginWord, string endWord, vector<string> &wordList)
    {
        if (!beginWord.compare(endWord))
            return 1;
        unordered_set<string> dict(wordList.begin(), wordList.end());
        queue<string> toVisit;
        toVisit.push(beginWord);
        int dist = 2;
        while (!toVisit.empty())
        {
            int n = toVisit.size();
            for (int i = 0; i < n; i++)
            {
                string word = toVisit.front();
                toVisit.pop();
                for (int i = 0; i < word.size(); i++)
                {
                    // process current
                    char letter = word[i];
                    for (int k = 0; k < 26; k++)
                    {
                        word[i] = 'a' + k;
                        if (dict.find(word) != dict.end())
                        {
                            if (word == endWord)
                                return dist;
                            toVisit.push(word);
                            dict.erase(word);
                        }
                    }
                    // restore
                    word[i] = letter;
                }
            }
            dist++;
        }
        return 0;
    }
};
