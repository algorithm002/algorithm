public class LeetCode_53_28 {

    public int maxSubArray(int[] nums) {

        int maxArrayLength=Integer.MIN_VALUE;
        Integer[] arr=new Integer[nums.length];
        for (int i=0;i<nums.length;i++){
            maxArrayLength=Math.max(maxArrayLength,max(nums,arr,i));

        }
        return maxArrayLength;
    }


    public int max(int[] nums,Integer[] arr,int index){
        if(arr[index]!=null){
            return arr[index];
        }
        if(index==0){
            arr[0]=nums[0];
            return nums[0];
        }else {
            int ret= Math.max(0,max(nums,arr,index-1)) + nums[index];
            arr[index] =ret ;
            return ret ;
        }
    }

    public static void main(String[] args) {
        int[] arr= {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new LeetCode_53_28().maxSubArray(arr));
    }

}
