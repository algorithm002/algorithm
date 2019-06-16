//Given two strings s and t , write a function to determine if t is an anagram of s.
//
// Example 1:
//
//
//Input: s = "anagram", t = "nagaram"
//Output: true
//
//
// Example 2:
//
//
//Input: s = "rat", t = "car"
//Output: false
//
//
// Note:
//You may assume the string contains only lowercase alphabets.
//
// Follow up:
//What if the inputs contain unicode characters? How would you adapt your solution to such case?
//


class Solution1
{
    public boolean isAnagram(String s, String t)
    {
        if (s == null || t == null || s.length() != t.length())
        {
            return false;
        }
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101};
        BigInteger productS = BigInteger.valueOf(1);
        BigInteger productT = BigInteger.valueOf(1);
        for (int i = 0; i < s.length(); i++)
        {
            productS = productS.multiply(BigInteger.valueOf(prime[s.charAt(i) - 'a']));
        }
        for (int i = 0; i < t.length(); i++)
        {
            productT = productT.multiply(BigInteger.valueOf(prime[t.charAt(i) - 'a']));
        }
        return productS.compareTo(productT) == 0;
    }
}


class Solution2
{
    public boolean isAnagram(String s, String t)
    {
        if (s == null || t == null || s.length() != t.length())
        {
            return false;
        }
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++)
        {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++)
        {
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int letter : alphabet)
        {
            if (letter != 0)
            {
                return false;
            }
        }
        return true;
    }
}