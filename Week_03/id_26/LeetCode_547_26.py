#
# @lc app=leetcode.cn id=547 lang=python
#
# [547] 朋友圈
#
# https://leetcode-cn.com/problems/friend-circles/description/
#
# algorithms
# Medium (50.43%)
# Likes:    100
# Dislikes: 0
# Total Accepted:    6.5K
# Total Submissions: 12.9K
# Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]'
#
# 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C
# 的朋友。所谓的朋友圈，是指所有朋友的集合。
#
# 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j
# 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
#
# 示例 1:
#
#
# 输入:
# [[1,1,0],
# ⁠[1,1,0],
# ⁠[0,0,1]]
# 输出: 2
# 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
# 第2个学生自己在一个朋友圈。所以返回2。
#
#
# 示例 2:
#
#
# 输入:
# [[1,1,0],
# ⁠[1,1,1],
# ⁠[0,1,1]]
# 输出: 1
# 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
#
#
# 注意：
#
#
# N 在[1,200]的范围内。
# 对于所有学生，有M[i][i] = 1。
# 如果有M[i][j] = 1，则有M[j][i] = 1。
#
#
#


class Solution(object):

    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        解法1：dfs
        深度遍历，用集合存储已经访问过的节点，如果访问过则跳过，否则朋友圈+1
        """
        visited, ans = set(), 0

        def dfs(i):
            for j in range(len(M[i])):
                if M[i][j] and j not in visited:
                    visited.add(j)
                    dfs(j)

        for i in range(len(M)):
            if i not in visited:
                dfs(i)
                ans += 1
        return ans

    def findCircleNum2(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        解法2：并查集
        首先每个人都是自己的朋友圈，所以先建立一个对应关系指向自己
        如果i和j是朋友，则i的朋友圈合并j的朋友圈，即j所在圈的根节点指向i所在圈的根节点
        最后数一下指向自己的节点有几个，即根节点的数量，即朋友圈的数量
        """
        n = len(M)
        circles = {i: i for i in range(n)}

        def find(i):
            if i == circles[i]:
                return i
            circles[i] = find(circles[i])
            return circles[i]

        for i in range(n):
            for j in range(i + 1, n):
                if M[i][j] == 1:
                    circles[find(i)] = find(j)

        return sum([1 for k, v in circles.items() if k == v])


print(Solution().findCircleNum2([[1, 0, 0], [0, 1, 0], [0, 0, 1]]))
print(Solution().findCircleNum2([[1, 1, 0], [1, 1, 0], [0, 0, 1]]))
print(Solution().findCircleNum2([[1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0],
                                 [1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                                 [0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                                 [0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0],
                                 [0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0],
                                 [0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0],
                                 [0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0],
                                 [1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0],
                                 [0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0],
                                 [0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1],
                                 [0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0],
                                 [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
                                 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
                                 [0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0],
                                 [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1]]
                                ))
