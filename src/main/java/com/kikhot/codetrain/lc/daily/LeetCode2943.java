package com.kikhot.codetrain.lc.daily;

import java.util.Arrays;

public class LeetCode2943 {

	public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
		int hMaxLen = findMaxLen(hBars);
		int vMaxLen = findMaxLen(vBars);
		int len = Math.min(hMaxLen, vMaxLen) + 1;
		return len * len;
	}

	public int findMaxLen(int[] bars) {
		Arrays.sort(bars);
		int resMax = 1;
		int count = 1;
		for (int i = 1; i < bars.length; i++) {
			if (bars[i] == bars[i - 1] + 1) {
				count++;
				resMax = Math.max(resMax, count);
			} else {
				count = 1;
			}
		}
		return resMax;
	}

}
