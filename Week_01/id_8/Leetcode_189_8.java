class Solution {
    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k%nums.length;
        }
        int[] rememberArray = new int[k];
        int j = 0;
        for (int i = nums.length-k; i< nums.length; i++) {
            rememberArray[j] = nums[i];
            j++;
        }
        for (int i=nums.length-k-1; i>=0; i--) {
            nums[i+k] = nums[i];
        }
        for (int i=0; i<k; i++) {
            nums[i] = rememberArray[i];
        }
    }
}