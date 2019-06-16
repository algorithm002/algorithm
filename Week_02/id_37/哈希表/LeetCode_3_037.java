class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int n=s.length();
        int l=0,r=0;//[l,r)不含有重复字符的滑动窗口
        Set<Character> set = new HashSet<>();
        while(l<n&&r<n){
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r++));
                max=Math.max(max,r-l);
            }else{
                set.remove(s.charAt(l++));
            }
        }
        return max;
    }
}