class Solution {
public:
    struct CourseRelations
	{
		CourseRelations() : count(0) { }
		int count;
		vector<int> nextCourses;
	};
	vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
		vector<CourseRelations> crVec(numCourses);
		for (int i = 0; i < prerequisites.size(); ++i)
		{
			int preCourse = prerequisites[i][1];
			int postCourse = prerequisites[i][0];
			++crVec[postCourse].count;
			crVec[preCourse].nextCourses.push_back(postCourse);
		}
		queue<int> selectedCourses;
		for (int i = 0; i < crVec.size(); ++i)
		{
			if (crVec[i].count == 0)
			{
				selectedCourses.push(i);
			}
		}
        vector<int> orders;
		while(!selectedCourses.empty())
		{
			int selectedCourse = selectedCourses.front();
			selectedCourses.pop();
			orders.push_back(selectedCourse);
			for (int course : crVec[selectedCourse].nextCourses)
			{
				if (--crVec[course].count == 0)
				{
					selectedCourses.push(course);
				}
			}
		}
		if (orders.size() < numCourses)
		{
			orders.clear();
		}
		return orders;
	}
};