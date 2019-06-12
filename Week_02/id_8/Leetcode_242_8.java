class Solution {
    public boolean isAnagram(String s, String t) {
        // 优化，直接返回false
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        // 构建hashmap
        for (int i = 0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        // 判断t
        for (int i = 0; i<t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }
        System.out.println(map.get('a'));
        for (int i = 0; i<s.length(); i++) {
            if (map.get(s.charAt(i)) != 0){
                System.out.println(s.charAt(i)+"不是0");
                return false;
            }
        }
        return true;
    }
}