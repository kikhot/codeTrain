package com.kikhot.codetrain.lc.daily;

import java.util.LinkedList;
import java.util.List;

public class LeetCode118 {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> resultList = new LinkedList<>();
		List<Integer> lastList = new LinkedList<>();
		lastList.add(1);
		resultList.add(lastList);
		for (int i = 1; i < numRows; i++) {
			List<Integer> thisList = new LinkedList<>();
			thisList.add(1);
			for (int j = 0; j < lastList.size() - 1; j++) {
				thisList.add(lastList.get(j) + lastList.get(j + 1));
			}
			thisList.add(1);
			resultList.add(thisList);
			lastList = thisList;
		}
		return resultList;
	}


}
