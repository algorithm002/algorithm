package com.llz.algorithm.algorithm2019.firstweek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LeetCode_49_2 {
	

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<List<String>>();
		Map<Integer, List<String>> mapList = new HashMap<>();
		List<String> subList = new ArrayList<>();
		char[] temp;
		for (int i = 0; i < strs.length; i++) {
			temp = strs[i].toCharArray();
			Arrays.sort(temp);
			int hash = String.valueOf(temp).hashCode();
			if ((subList = mapList.get(hash)) == null) {
				subList = new ArrayList<>();
			}
			subList.add(strs[i]);
			mapList.put(hash, subList);
		}
		Iterator<Map.Entry<Integer, List<String>>> it = mapList.entrySet().iterator();
		while (it.hasNext()) {
			list.add(it.next().getValue());
		}
		return list;
	}

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> list = groupAnagrams(strs);
		System.out.println(list);
	}

}
