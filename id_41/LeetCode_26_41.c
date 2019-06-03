int removeDuplicates(int* nums, int numsSize) {
    int i = 0;
    for (int j = 0; j < numsSize; j++)
    {
        if (!i || nums[j] > nums[i-1])
        {
            nums[i] = nums[j];
	    i++;
	}
    }
    return i;
}
