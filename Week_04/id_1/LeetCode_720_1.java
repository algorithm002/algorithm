package week01;

import java.util.Arrays;

public class LeetCode_720_1 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_720_1().longestWord(new String[]{"w","wo","wor","worl", "world"}));
    }

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) return "";
        Arrays.sort(words);
        int len = 0;
        for (String word : words) {
            len=Math.max(len,word.length());
        }
        for (int i = len; i > 0; i--) {
            for (int j = 0; j < words.length; j++) {
                if (words[j].length() == i) {
                    int temp = i;
                    for (int k = j - 1; k >= 0; k--) {
                        if (words[j].substring(0, temp - 1).equals(words[k])) {
                            temp--;
                        }
                    }
                    if (temp == 1) return words[j];
                }
            }
        }
        return "";
    }
}
