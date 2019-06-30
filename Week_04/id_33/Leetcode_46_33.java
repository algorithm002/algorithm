/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(nums, result, new ArrayList<>());
        return result;
    }
    
    public void backTrace(int[] nums, List<List<Integer>> result, List<Integer> tempList){
        if(tempList.size() == nums.length){
            result.add(new ArrayList<Integer>(tempList));
            return;
        }
        
        for(int i = 0; i< nums.length; i++){
            if(tempList.contains(nums[i])) continue;
            tempList.add(nums[i]);
            backTrace(nums, result, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}

