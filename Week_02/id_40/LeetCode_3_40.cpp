/*
 * @lc app=leetcode id=3 lang=cpp
 *
 * [3] Longest Substring Without Repeating Characters
 */
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
         int  size,i=0,j,k,max=0;
        size = s.size();
        for(j = 0;j<size;j++)
        {
            for(k = i;k<j;k++)
            {
                if(s[k]==s[j])
                {
                    i = k+1;
                    break;
                }
            }
            if(j-i+1 > max)
                max = j-i+1;
        }
        return max;
    }
};

