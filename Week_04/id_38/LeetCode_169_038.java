/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 求众数
 */

class LeetCode_169_038 {

  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length/2];
  }

  public int majorityElement2(int[] nums) {
    int majorityCount = nums.length / 2;

    Map<Integer, Integer> countMap = new HashMap();
    for (int num : nums) {
      if (countMap.get(num) != null) {
        countMap.put(num, countMap.get(num) + 1);
      } else {
        countMap.put(num, 1);
      }

      if (countMap.get(num) > majorityCount) {
        return num;
      }
    }

    return -1;
  }
}
