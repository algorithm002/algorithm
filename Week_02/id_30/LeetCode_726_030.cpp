class Solution {
public:
    map<string, int> atomsCountMap;

	void insertOrUpdateAtomsCountMap(const pair<string, int>& p)
	{
		auto iter = atomsCountMap.find(p.first);
		if (iter != atomsCountMap.end())
		{
			iter->second += p.second;
		}
		else
		{
			atomsCountMap.insert(p);
		}
	}

	int parseNumber(const string& formula, int startIndex, int& endIndex)
	{
		if (!isdigit(formula[startIndex]))
		{
			endIndex = startIndex - 1;
			return 1;
		}
		int i = startIndex + 1;
		while (isdigit(formula[i]))  ++i;
		string numStr = formula.substr(startIndex, i - startIndex);
		endIndex = i - 1;
		return stoi(numStr);
	}

	string countOfAtoms(string formula) {
		stack<pair<string, int>> parenthesesStack;
		for (int i = 0; i < formula.size(); ++i)
		{
			char c = formula[i];
			if (isupper(c))
			{
				int strParseStartIndex = i;
				while (islower(formula[i + 1]))  ++i;
				string atomName = formula.substr(strParseStartIndex, i - strParseStartIndex + 1);
				int count = parseNumber(formula, i + 1, i);
				if (parenthesesStack.empty())
				{
					insertOrUpdateAtomsCountMap(make_pair(atomName, count));
				}
				else
				{
					parenthesesStack.push(make_pair(atomName, count));
				}
			}
			else if (c == '(')
			{
				parenthesesStack.push(make_pair("(", 0));
			}
			else if (c == ')')
			{
				int multiplier = parseNumber(formula, i + 1, i);
				stack<pair<string, int>> multiplierStack;
				while (!parenthesesStack.empty())
				{
					pair<string, int> namePair = parenthesesStack.top();
					parenthesesStack.pop();
					if (namePair.first == "(")
					{
						if (parenthesesStack.empty())
						{
							while (!multiplierStack.empty())
							{
								pair<string, int> mPair = multiplierStack.top();
								multiplierStack.pop();
								insertOrUpdateAtomsCountMap(mPair);
							}
						}
						else
						{
							while (!multiplierStack.empty())
							{
								parenthesesStack.push(multiplierStack.top());
								multiplierStack.pop();
							}
						}
						break;
					}
					else
					{
						namePair.second *= multiplier;
						multiplierStack.push(namePair);
					}
				}
			}
		}

		string elements;
		for (pair<string, int> p : atomsCountMap)
		{
			elements += p.first;
			if (p.second > 1)  elements += to_string(p.second);
		}
		return elements;
	}
};