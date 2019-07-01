public class LeetCode_213_28 {
    public int rob(int[] nums) {


        Integer[] arr1=new Integer[nums.length];
        Integer[] arr2=new Integer[nums.length];

        return nums.length==0 ? 0 : Math.max(dp1(nums,arr1,nums.length-1),dp2(nums,arr2,nums.length-1));

    }

    public int dp1(int[] nums,Integer[] arr,int i){
        if(arr[i] == null){
            if (i==0){
                arr[i] = nums[0];
            }else if(i==1){
                arr[i] = nums[0];
            }else if(i<nums.length-1){
                arr[i]=Math.max(dp1(nums,arr,i-2)+nums[i],dp1(nums,arr,i-1));
            }else {
                arr[i]=dp1(nums,arr,i-1);
            }
        }
        return arr[i];
    }


    public int dp2(int[] nums,Integer[] arr,int i){
        if(arr[i] == null){
            if (i==0){
                arr[i] = 0;
            }else if(i==1){
                arr[i] = nums[1];
            }else {
                arr[i]=Math.max(dp2(nums,arr,i-2)+nums[i],dp2(nums,arr,i-1));
            }
        }
        return arr[i];
    }



    public static void main(String[] args) {
        int[] arr= {1,2,1,1};
        System.out.println(new LeetCode_213_28().rob(arr));
    }
}
