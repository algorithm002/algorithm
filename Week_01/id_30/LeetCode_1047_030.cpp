class Solution {
public:
    string removeDuplicates(string S) {
        string nonDuplicateString;
        for (char c : S)
        {
            if (!nonDuplicateString.empty() && nonDuplicateString.back() == c)
            {
                nonDuplicateString.pop_back();
            }
            else
            {
                nonDuplicateString.push_back(c);
            }
        }
        
        return nonDuplicateString;
    }
};