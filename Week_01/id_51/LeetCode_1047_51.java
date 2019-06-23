class Solution {
    public String removeDuplicates(String S) {
        if (S == null) return S;
        StringBuilder sb = new StringBuilder();
        
        for (char c : S.toCharArray()) {
            int length = sb.length();
            if (length == 0 || sb.charAt(length - 1) != c) {
                sb.append(c);
            } else {
                sb.deleteCharAt(length - 1);
            }                            
        }
        
        return sb.toString();
    }
}
