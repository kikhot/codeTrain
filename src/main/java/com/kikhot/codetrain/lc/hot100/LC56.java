package com.kikhot.codetrain.lc.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56 {

	public int[][] merge(int[][] intervals) {

		// 按照数组中第一个元素排序
		Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

		List<int[]> merged = new ArrayList<>();

		merged.add(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			if (merged.getLast()[1] >= intervals[i][0]) {
				merged.getLast()[1] = Math.max(merged.getLast()[1], intervals[i][1]);
				continue;
			}
			merged.add(intervals[i]);
		}

		return merged.toArray(new int[merged.size()][]);

	}

}
