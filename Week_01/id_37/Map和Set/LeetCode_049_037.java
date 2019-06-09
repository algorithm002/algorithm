public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key=String.valueOf(chars);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}