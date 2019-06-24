/*
 * @lc app=leetcode id=547 lang=cpp
 *
 * [547] Friend Circles
 */
class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
         bool check[M.size()] {};
        queue<int> q;
        int sol = 0;
        for(int i = 0; i < M.size(); i++){
            if(!check[i]) sol++, q.push(i), check[i] = 1;
            while(!q.empty()){
                int res = q.front();
                q.pop();
                for(int n = 0; n < M.size(); n++)
                    if(M[res][n] && !check[n]) q.push(n), check[n] = 1;
            }
        }
        return sol;
    }
};

