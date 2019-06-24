/*
 * @lc app=leetcode id=329 lang=cpp
 *
 * [329] Longest Increasing Path in a Matrix
 */
class Solution {
public:
    // dp[i][j][k]表示matrix[i][j]结尾且数组长度不超过k时的最长递增路径长度
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        
        int m = matrix.size(); if(m==0) return 0;
        int n = matrix[0].size(); if(n==0) return 0;
        vector<vector<vector<int>>> dp(m, vector<vector<int>>(n, vector<int>{1,1}));
        int cur = 0;
        int ans = 1;
        while(1){
            bool is_change = false;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    // 给定matrix[i][j], 选择其前面最近邻的节点使得dp[i][j]最大
                    int old = dp[i][j][cur];
                    if(i-1>=0 && matrix[i][j]>matrix[i-1][j] && 1+dp[i-1][j][cur]>dp[i][j][1-cur]) dp[i][j][1-cur] = 1+dp[i-1][j][cur];
                    if(i+1<m  && matrix[i][j]>matrix[i+1][j] && 1+dp[i+1][j][cur]>dp[i][j][1-cur]) dp[i][j][1-cur] = 1+dp[i+1][j][cur];
                    if(j-1>=0 && matrix[i][j]>matrix[i][j-1] && 1+dp[i][j-1][cur]>dp[i][j][1-cur]) dp[i][j][1-cur] = 1+dp[i][j-1][cur];
                    if(j+1<n  && matrix[i][j]>matrix[i][j+1] && 1+dp[i][j+1][cur]>dp[i][j][1-cur]) dp[i][j][1-cur] = 1+dp[i][j+1][cur];
                    if(old!=dp[i][j][1-cur]) is_change = true;
                }
            }
            if(is_change){
                ans++;
                cur = 1-cur;
            }else{
                return ans;
            }
        }
        return ans;
    }

};

