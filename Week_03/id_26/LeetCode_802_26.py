#
# @lc app=leetcode.cn id=802 lang=python
#
# [802] 找到最终的安全状态
#
# https://leetcode-cn.com/problems/find-eventual-safe-states/description/
#
# algorithms
# Medium (37.58%)
# Likes:    14
# Dislikes: 0
# Total Accepted:    543
# Total Submissions: 1.5K
# Testcase Example:  '[[1,2],[2,3],[5],[0],[5],[],[]]'
#
# 在有向图中, 我们从某个节点和每个转向处开始, 沿着图的有向边走。 如果我们到达的节点是终点 (即它没有连出的有向边), 我们停止。
#
# 现在, 如果我们最后能走到终点，那么我们的起始节点是最终安全的。 更具体地说, 存在一个自然数 K,  无论选择从哪里开始行走, 我们走了不到 K
# 步后必能停止在一个终点。
#
# 哪些节点最终是安全的？ 结果返回一个有序的数组。
#
# 该有向图有 N 个节点，标签为 0, 1, ..., N-1, 其中 N 是 graph 的节点数.  图以以下的形式给出: graph[i] 是节点 j
# 的一个列表，满足 (i, j) 是图的一条有向边。
#
#
# 示例：
# 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
# 输出：[2,4,5,6]
# 这里是上图的示意图。
#
#
#
#
#
# 提示：
#
#
# graph 节点数不超过 10000.
# 图的边数不会超过 32000.
# 每个 graph[i] 被排序为不同的整数列表， 在区间 [0, graph.length - 1] 中选取。
#
#
#

import collections


class Solution(object):
    def eventualSafeNodes1(self, graph):
        """
        :type graph: List[List[int]]
        :rtype: List[int]
        This is equal to find nodes which doesn't lead to a circle in any path.
        We can solve it by walking along the path reversely.

        Find nodes with out degree 0, they are terminal nodes,
        we remove them from graph and they are added to result
        For nodes who are connected terminal nodes,
        since terminal nodes are removed,
        we decrease in-nodes' out degree by 1 and if its out degree equals to 0,
        it become new terminal nodes
        Repeat 2 until no terminal nodes can be found.
        """
        n = len(graph)
        out_degree = collections.defaultdict(int)
        in_nodes = collections.defaultdict(list)

        queue = []
        ret = []
        for i in range(n):
            out_degree[i] = len(graph[i])
            if out_degree[i] == 0:
                queue.append(i)
            for j in graph[i]:
                in_nodes[j].append(i)

        while queue:
            term_node = queue.pop(0)
            ret.append(term_node)
            for in_node in in_nodes[term_node]:
                out_degree[in_node] -= 1
                if out_degree[in_node] == 0:
                    queue.append(in_node)
        return sorted(ret)

    def eventualSafeNodes(self, graph):
        n = len(graph)
        out_degree, in_nodes = [],[[] for i in range(n)]
        queue, ans= [], set()
         
        for i in range(len(graph)):
            out_degree.append(len(graph[i]))
            if not graph[i]:
                queue.append(i)
            for j in graph[i]:
                in_nodes[j].append(i)

        while queue:
            i = queue.pop()
            ans.add(i)
            for j in in_nodes[i]:
                out_degree[j] -= 1
                if out_degree[j] == 0:
                    queue.append(j)
        return sorted(ans)

