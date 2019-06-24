"""
经典的拓扑排序
numCourses 课程数
prerequisites 课程依赖关系 也就是边列表
BFS
"""


class Solution:
    def findOrder(self, numCourses, prerequisites):
        queue = []
        node_list = [[] for _ in range(numCourses)]
        topology_list = [0 for _ in range(numCourses)]

        for e in prerequisites:
            node_list[e[1]].append(e[0])
            topology_list[e[0]] += 1

        for i, n in enumerate(topology_list):
            if n == 0:
                queue.append(i)

        results = []
        while queue:
            node = queue.pop()
            results.append(node)
            for sn in node_list[node]:
                topology_list[sn] -= 1
                if topology_list[sn] == 0:
                    queue.insert(0, sn)

        if len(results) != numCourses:
            return []
        return results
