package longestSubstring03;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int first=0;
        int last;
        int len=s.length();
        if (len==0){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        Map<Character,Integer> map=new HashMap<>();
        for (last=0;last<len;last++){
            char c=s.charAt(last);
            if (map.containsKey(c)){
                int first_old=first;
                first=map.get(c)+1;
                max=Math.max(max,map.size());
                for (int i=first_old;i<first;i++){
                    map.remove(s.charAt(i));
                }
                map.put(c,last);
            }else if(last==len-1){
                map.put(c,last);
                max=Math.max(max,map.size());
            }
            else {
                map.put(c,last);
            }
        }
        return max;
    }
}
