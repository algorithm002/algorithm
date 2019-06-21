class Solution:
    def findOrder(self, numCourses, prerequisites):
        node_list = list([] for _ in range(numCourses))
        topology_list = list(0 for _ in range(numCourses))

        for t, s in prerequisites:
            node_list[s].append(t)
            topology_list[t] += 1

        results = []
        visited = set()
        for e in list(filter(lambda e: e[1] == 0, enumerate(topology_list))):
            results.append(e[0])
            if not self.dfs(e[0], node_list, topology_list, visited, results):
                return []

        if len(results) != numCourses:
            return []
        return results

    def dfs(self, node, node_list, topology_list, visited, results):
        if node in visited:
            return False
        visited.add(node)
        for sn in node_list[node]:
            topology_list[sn] -= 1
            if topology_list[sn] == 0:
                results.append(sn)
                if not self.dfs(sn, node_list, topology_list, visited, results):
                    return False
        visited.remove(node)
        return True


s = Solution()
print(s.findOrder(4, [[2, 0], [1, 0], [3, 1], [3, 2], [1, 3]]))
print(s.findOrder(7, [[1, 0], [0, 3], [0, 2], [3, 2], [2, 5], [4, 5], [5, 6], [2, 4]]))
print(s.findOrder(3, [[1, 0], [1, 2], [0, 1]]))
