/*
 * @lc app=leetcode id=49 lang=cpp
 *
 * [49] Group Anagrams
 */
/*将每一个字符串排序之后放进哈希表中
   遍历哈希表，将结果放进返回中
*/
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res;
        unordered_map<string, vector<string>> map;
        sort(strs.begin(), strs.end());
        for(auto& s: strs){
            string temp = s;
            sort(s.begin(), s.end());
            if(map.find(s) == map.end()){
                map[s] = vector<string>();
                map[s].push_back(temp);
            }
            else{
                map[s].push_back(temp);
            }
        }
        
        for(auto& pair: map){
            res.push_back(pair.second);
        }
        return res;
    }
};

