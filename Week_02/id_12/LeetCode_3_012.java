class Solution {
    public int lengthOfLongestSubstring(String s) {
        Deque<Character> characterDeque = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characterDeque.contains(c)) {
                int len = characterDeque.size();
                if (len > result) {
                    result = len;
                }
                while (c != characterDeque.peek()) {
                    characterDeque.poll();
                }
                characterDeque.poll();
            }
            characterDeque.add(c);
        }
        int size = characterDeque.size();
        return size > result ? size : result;
    }
}