class Solution {
    public String removeOuterParentheses(String S) {                
        int open = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {            
            if (c == '(' && open++ != 0) sb.append(c);
            if (c == ')' && open-- != 1) sb.append(c);            
        }
        return sb.toString();
    }
}
