public class LeetCode_198_28 {
    public int rob(int[] nums) {


        Integer[] arr=new Integer[nums.length];
        //Integer max=Integer.MIN_VALUE;
        return nums.length==0 ? 0 : dp(nums,arr,nums.length-1);

    }

    public int dp(int[] nums,Integer[] arr,int i){
        if(arr[i] == null){
            if (i==0){
                arr[i] = nums[0];
            }else if(i==1){
                arr[i] = Math.max(nums[0],nums[1]);
            }else {
                arr[i]=Math.max(dp(nums,arr,i-2)+nums[i],dp(nums,arr,i-1));
            }
        }
        return arr[i];
    }

    public static void main(String[] args) {
        int[] arr= {1,2,3,1};
        System.out.println(new LeetCode_198_28().rob(arr));
        System.out.println("hello");
    }
}
