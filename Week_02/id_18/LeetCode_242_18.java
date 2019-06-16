package Week_02.id_18;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author LiveForExperience
 * @date 2019/6/4 13:09
 */
public class LeetCode_242_18 {
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] tc = t.toCharArray();
        for (char sc : s.toCharArray()) {
            for (int i = 0; i < tc.length; i++) {
                if (sc == tc[i]) {
                    tc[i] = '#';
                    break;
                }
            }
        }

        for (char c : tc) {
            if (c != '#') {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<String, Long> map = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (String ts : t.split("")) {
            if (map.containsKey(ts)) {
                map.put(ts, map.get(ts) - 1);
                continue;
            }
            return false;
        }

        for (Long value : map.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Integer, Long> map = s.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (char c : t.toCharArray()) {
            int ci = (int) c;
            if (map.containsKey(ci)) {
                map.put(ci, map.get(ci) - 1);
                continue;
            }
            return false;
        }

        for (Long value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram4(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs, ct);
    }

    public boolean isAnagram5(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] countArr = new int[26];

        for (int i = 0; i < cs.length; i++) {
            countArr[cs[i] - 'a']++;
            countArr[ct[i] - 'a']--;
        }

        for (int i : countArr) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram6(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};
        BigDecimal productS = BigDecimal.valueOf(1);
        BigDecimal productT = BigDecimal.valueOf(1);
        for (int i = 0; i < s.length(); i++) {
            productS = productS.multiply(BigDecimal.valueOf(prime[s.charAt(i) - 'a']));
        }
        for (int i = 0; i < t.length(); i++) {
            productT = productT.multiply(BigDecimal.valueOf(prime[t.charAt(i) - 'a']));
        }
        return productS.compareTo(productT) == 0;
    }

    public boolean isAnagram7(String s, String t) {
        int[] alphabet = new int[26];
        for (char c : s.toCharArray()) {
            alphabet[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            alphabet[c - 'a']--;
        }
        for (int a : alphabet) {
            if (a != 0) {
                return false;
            }
        }
        return true;
    }
}
