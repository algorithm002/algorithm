"""
经典的拓扑排序
numCourses 课程数
prerequisites 课程依赖关系 也就是边列表
DFS

由于我使用的是从起点向后下钻，当遇到新的入度为0的节点才下钻，所以不会出现死循环的问题。
如果是从后向前，或者不判断入度数量，可能就需要一个visited的缓存来判断是否在迭代过程中出现了环。
"""


class Solution:
    def findOrder(self, numCourses, prerequisites):
        node_list = list([] for _ in range(numCourses))
        topology_list = list(0 for _ in range(numCourses))

        for t, s in prerequisites:
            node_list[s].append(t)
            topology_list[t] += 1

        results = []
        for e in list(filter(lambda e: e[1] == 0, enumerate(topology_list))):
            results.append(e[0])
            self.dfs(e[0], node_list, topology_list, results)

        if len(results) != numCourses:
            return []
        return results

    def dfs(self, node, node_list, topology_list, results):
        for sn in node_list[node]:
            topology_list[sn] -= 1
            if topology_list[sn] == 0:
                results.append(sn)
                self.dfs(sn, node_list, topology_list, results)


s = Solution()
print(s.findOrder(4, [[2, 0], [1, 0], [3, 1], [3, 2], [1, 3]]))
print(s.findOrder(7, [[1, 0], [0, 3], [0, 2], [3, 2], [2, 5], [4, 5], [5, 6], [2, 4]]))
print(s.findOrder(3, [[1, 0], [1, 2], [0, 1]]))
