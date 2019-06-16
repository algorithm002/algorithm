//Given an array of strings, group anagrams together.
//
// Example:
//
//
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// Note:
//
//
// All inputs will be in lowercase.
// The order of your output does not matter.
//
//

class Solution
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        if (strs == null || strs.length == 0)
        {
            return new ArrayList<>(0);
        }
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101};
        HashMap<Integer, List<String>> map = new HashMap<>();
        int product;
        for (String str : strs)
        {
            product = 1;
            for (char c : str.toCharArray())
            {
                product *= prime[c - 'a'];
            }
            if (map.containsKey(product))
            {
                map.get(product).add(str);
            }
            else
            {
                List<String> list = new LinkedList<>();
                list.add(str);
                map.put(product, list);
            }
        }
        return new LinkedList<>(map.values());
    }
}