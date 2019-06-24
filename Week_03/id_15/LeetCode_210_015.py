class Solution:
    def dfs(self, n, g, flags, seqs):
        if flags[n] == 0: return False
        if flags[n] == 1: return True
        
        flags[n] = 0
        for m in g[n]:
            if not self.dfs(m,g,flags,seqs): return False
        flags[n] = 1
        seqs.append(n)
        return True
    
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        
        g = [[] for _ in range(numCourses)]
        for b,a in prerequisites:
            g[a].append(b)
        
		# -1: not visited
		# 0: visiting
		# 1: visited
        flags = [-1]*numCourses
        seqs = []
        for i in range(numCourses):
            if not self.dfs(i,g,flags,seqs): return []
        
        seqs = seqs[::-1]
        return seqs
