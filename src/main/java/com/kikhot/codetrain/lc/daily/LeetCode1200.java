package com.kikhot.codetrain.lc.daily;

import java.util.*;

public class LeetCode1200 {

	public List<List<Integer>> minimumAbsDifference(int[] arr) {

		Arrays.sort(arr);
		List<List<Integer>> resList = new ArrayList<>();
		int minVal = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length; i++) {
			int diffValue = arr[i] - arr[i - 1];
			List<Integer> numList = new ArrayList<>();
			numList.add(arr[i - 1]);
			numList.add(arr[i]);
			if (diffValue == minVal) {
				resList.add(numList);
			} else if (diffValue < minVal) {
				minVal = diffValue;
				resList.clear();
				resList.add(numList);
			}
		}

		return resList;


	}

}
