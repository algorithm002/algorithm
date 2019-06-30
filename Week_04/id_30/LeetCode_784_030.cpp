class Solution {
public:
    vector<string> permuationResults;

	vector<string> letterCasePermutation(string S) {
		permutateString(S, 0);
		return permuationResults;
	}

	void permutateString(string& S, int i)
	{
		if (i >= S.size())
		{
			permuationResults.push_back(S);
			return;
		}
		permutateString(S, i + 1);
		if (isalpha(S[i]))
		{
			char prevChar = S[i];
			if (isupper(S[i])) S[i] = tolower(S[i]);
			else               S[i] = toupper(S[i]);
			permutateString(S, i + 1);
			S[i] = prevChar;
		}
	}
};