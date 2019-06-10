class Solution {
    public int removeDuplicates(int[] nums) {
        int numbers = 0;
        int arrayLength = nums.length;
        for (int i=0; i<arrayLength; i++) {
            for(int j=i+1; j<arrayLength; j++) {
                if(nums[i]!=nums[j]) {
                    numbers ++;
                    break;
                } else if (nums[i] == nums[j]){
                    removeElementArray(nums, j);
                    arrayLength = arrayLength-1;
                    j = j-1;
                }
            }
        }
        return numbers+1;
    }

    public void removeElementArray(int[] array, int index) {
        for (int i=index; i<array.length-1; i++) {
            array[i] = array[i+1];
        }
    }
}