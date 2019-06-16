public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy=new int[m];
        for(int i=0;i< m;i++){
            nums1_copy[i]=nums1[i];
        }
        int j=0;//nums1指针位置
        int p1=0;//nums1_copy指针位置
        int p2=0;//nums2指针位置
        while(j<m+n){
            if(p1==nums1_copy.length){
                for(int i=p2;i<nums2.length;i++){
                    nums1[j++]=nums2[i];
                }
                return;
            }
            if(p2==nums2.length){
                for(int i=p1;i<nums1_copy.length;i++){
                    nums1[j++]=nums1_copy[i];
                }
                return;
            }
            if(nums1_copy[p1]<=nums2[p2]){
                nums1[j++]=nums1_copy[p1++];
            }else{
                nums1[j++]=nums2[p2++];
            }

        }
    }

}