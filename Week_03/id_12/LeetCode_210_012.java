class Solution {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List[] course = new List[numCourses];
		int[] map = new int[numCourses];
		List<Integer> resultList = new ArrayList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			course[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < prerequisites.length; i++) {
			course[prerequisites[i][0]].add(prerequisites[i][1]);
		}
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(course, i, resultList, map)) {
				return new int[0];
			}
		}
		int[] an = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			an[i] = resultList.get(i);
		}
		return an;
	}

	private boolean dfs(List[] course, int req, List<Integer> list, int[] map) {
		if (map[req] == 0) {
			map[req] = 1;
			for (int i = 0; i < course[req].size(); i++) {
				if (!dfs(course, (int) course[req].get(i), list, map)) {
					return false;
				}
			}
			map[req] = 2;
		} else if (map[req] == 1) {
			return false;
		} else if (map[req] == 2) {
			return true;
		}
		list.add(req);
		return true;
	}
}