class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> waitMap=new HashMap<>();//{以等待的值为key,i}
        for(int i=0;i<nums.length;i++){
            if(waitMap.containsKey(nums[i])){
                return new int[]{waitMap.get(nums[i]),i};
            }
            waitMap.put(target-nums[i],i);
        }
        return null;
    }
}