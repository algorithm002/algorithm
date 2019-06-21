"""
经典的拓扑排序
numCourses 课程数
prerequisites 课程依赖关系 也就是边列表

在拓扑排序过程中如果无法完成则说明图中存在环 也就是返回False
例如图中存在 (0,1) (1,2) (2,0) 形成一个环
则三个节点0,1,2的入度都不小于1，在进行拓扑排序时，三个节点由于环的存在，不会出现有节点降为0的情况。

DFS实现
"""


class Solution:
    def canFinish(self, numCourses, prerequisites):
        node_list = [[] for _ in range(numCourses)]
        topology_list = [0 for _ in range(numCourses)]

        for e in prerequisites:
            node_list[e[1]].append(e[0])
            topology_list[e[0]] += 1

        for i, n in list(filter(lambda e: not e[1], enumerate(topology_list))):
            self.dfs(i, node_list, topology_list)

        for count in topology_list:
            if count != 0:
                return False
        return True

    def dfs(self, node, node_list, topology_list):
        for sn in node_list[node]:
            print('sn', sn)
            topology_list[sn] -= 1
            if topology_list[sn] == 0:
                self.dfs(sn, node_list, topology_list)


s = Solution()
# print(s.canFinish(2, [[1, 0]]))
# print(s.canFinish(2, [[1, 0], [0, 1]]))
# print(s.canFinish(3, [[0, 1], [0, 2], [1, 2]]))
# print(s.canFinish(3, [[1, 0], [2, 0]]))
print(s.canFinish(3, [[0, 1], [0, 2], [1, 2]]))
