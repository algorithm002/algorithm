# 学习笔记

# [LeetCode174 题目](https://leetcode.com/problems/dungeon-game/)
    
 这个题目主要利用动态规划，
 需要反过来想，状态方程为： 
     
     dp[i][j] = max(1, min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
  
 
 
# [leetCode368 题目](https://leetcode.com/problems/largest-divisible-subset/)
  这个题目利用了stack 这种数据结构
  时间复杂度为 0(n)  
  计算栈内数据的时候，有两个触发条件，当前数据并栈顶元素小了。或者到了最右端。
  栈里面的元素是数据的下标，其实是用来计算矩形的宽度的。矩形的高度在出栈的时间就计算处理了。 