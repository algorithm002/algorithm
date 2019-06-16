/*
 * @lc app=leetcode id=726 lang=cpp
 *
 * [726] Number of Atoms
 * T(n) = O(N)
 * S(n) = O(N)
 */
class Solution
{
public:
    string countOfAtoms(string f)
    {
        stack<map<string, int>> st;
        map<string, int> cur;
        int i = 0;
        while (i < f.size())
        {
            if (f[i] == '(')
            {
                processLeftBracket(cur, st, i);
            }
            else if (f[i] == ')')
            {
                processRightBracket(i, f, cur, st);
            }
            else
            {
                processCount(i, f, cur);
            }
        }
        string ans;
        for (auto p : cur)
        {
            ans += p.first;
            if (p.second > 1)
                ans += to_string(p.second);
        }

        return ans;
    }

private:
    void processLeftBracket(map<string, int> &cur,
                            stack<map<string, int>> &st,
                            int &i)
    {
        st.push(move(cur));
        cur = map<string, int>();
        ++i;
    }

    void processRightBracket(int &i,
                             string f,
                             map<string, int> &cur,
                             stack<map<string, int>> &st)
    {
        int j = i + 1;
        int num = 0;
        while (j < f.size() && isdigit(f[j]))
            num = num * 10 + (f[j++] - '0');
        num = max(num, 1);
        for (auto p : cur)
            st.top()[p.first] += p.second * num;
        cur = move(st.top());
        st.pop();
        i = j;
    }

    void processCount(int &i,
                      string f,
                      map<string, int> &cur)
    {
        int j = i + 1;
        int num = 0;
        while (j < f.size() && f[j] >= 'a' && f[j] <= 'z')
            ++j;
        auto name = f.substr(i, j - i);
        while (j < f.size() && isdigit(f[j]))
            num = num * 10 + (f[j++] - '0');
        num = max(num, 1);
        cur[name] += num;
        i = j;
    }
};
