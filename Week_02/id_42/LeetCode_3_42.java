class Solution {
    static int[] last = new int[128];
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int len = 0;
        char[] w = new char[s.length()];
        w = s.toCharArray();
        for(int i = 0; i < 128; i++)
            last[i] = -1;//last数组用于保存新出现的字符的下标，一开始全部初始化为-1
        for(int i = 0; i < s.length(); ++ i){
            if(last[w[i]-' '] >= start){ //当前这个字符出现过
                if(i-start > len)
                    len = i-start;
                start = last[w[i]-' '] + 1; //从这个字符首次出现的位置+1，重新扫描，相当于把前面抛开前面的字符串不谈
            }
            last[w[i]-' '] = i;//更新当前字符的下标
        }
        if(len > s.length() - start)//针对没有重复字符的字符串
            return len;
        else
            return s.length() - start;
    }

}