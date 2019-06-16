public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int k=0;//[0,k]保存所有合法的非重复数字
        int c=nums[0];//当前比较的数字
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=c){
                nums[++k]=nums[i];
                c=nums[i];
            }
            continue;
        }
        return k+1;
    }

    public static void main(String[] args) {
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        int i = new Solution().removeDuplicates(nums);
        for(int j : nums){
            System.out.print(j+" ");
        }
    }
}