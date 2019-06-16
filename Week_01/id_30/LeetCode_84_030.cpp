class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        if (heights.empty())  return 0;
		heights.push_back(0); // put zero at the end to force to clear stack
		stack<pair<int, int>> ascendingStack;
		ascendingStack.push(make_pair(heights[0], 0));
		int maxArea = heights[0];
		for(int barIndex = 1; barIndex < heights.size(); ++barIndex)
		{
			if (heights[barIndex] > ascendingStack.top().first)
			{
				ascendingStack.push(make_pair(heights[barIndex], barIndex));
			}
			else if (heights[barIndex] == ascendingStack.top().first)
			{
				// previous bar with equal number will be overridden
				ascendingStack.top().second = barIndex;
			}
			else
			{
				do
				{
					int previousBarIndex = ascendingStack.top().second;
					int equalOrAfterwardsLargeBarsNumber = barIndex - previousBarIndex;

					ascendingStack.pop();

					int previousLargeBarsNumber = previousBarIndex;
					if (!ascendingStack.empty())
					{
						previousLargeBarsNumber = previousBarIndex - ascendingStack.top().second - 1;
					}

					int maxAreaForPreviousBar = (equalOrAfterwardsLargeBarsNumber + previousLargeBarsNumber) * heights[previousBarIndex];
					if (maxAreaForPreviousBar > maxArea)
					{
						maxArea = maxAreaForPreviousBar;
					}
				} while (!ascendingStack.empty() && heights[barIndex] < ascendingStack.top().first);

				if (ascendingStack.empty() || heights[barIndex] > ascendingStack.top().first)
				{
					ascendingStack.push(make_pair(heights[barIndex], barIndex));
				}
				else
				{
					ascendingStack.top().second = barIndex;
				}
			}
		}

		return maxArea;
    }
};