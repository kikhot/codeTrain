package com.kikhot.codetrain.lc.daily;

import java.util.*;

public class LeetCode49 {

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> sortSet = new HashMap<>();
		for (String str : strs) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String sortStr = Arrays.toString(charArray);
			if (sortSet.containsKey(sortStr)){
				sortSet.get(sortStr).add(str);
			}else{
				sortSet.put(sortStr, new ArrayList<>(List.of(str)));
			}
		}

		return new ArrayList<>(sortSet.values());
	}

}
