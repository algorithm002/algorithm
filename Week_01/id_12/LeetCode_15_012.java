//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
// Note:
//
// The solution set must not contain duplicate triplets.
//
// Example:
//
//
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
//


class Solution
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        if (nums == null || nums.length < 3)
        {
            return new ArrayList<>(0);
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        int i = 0, j, k, target;
        while (i < nums.length - 2)
        {
            if (i > 0 && nums[i] == nums[i - 1])
            {
                i++;
                continue;
            }
            j = i + 1;
            k = nums.length - 1;
            target = -nums[i];
            while (j < k)
            {
                if (nums[j] + nums[k] == target)
                {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j + 1] == nums[j])
                    {
                        j++;
                    }
                    while (j < k && nums[k - 1] == nums[k])
                    {
                        k--;
                    }
                    j++;
                    k--;
                }
                else if (nums[j] + nums[k] < target)
                {
                    j++;
                }
                else
                {
                    k--;
                }
            }
            i++;
        }
        return result;
    }
}