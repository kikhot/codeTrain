package com.kikhot.codetrain.lc.daily;

public class LeetCode3047 {

	public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
		int len = bottomLeft.length;
		int resLen = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				int leftX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
				int leftY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
				int rightX = Math.min(topRight[i][0], topRight[j][0]);
				int rightY = Math.min(topRight[i][1], topRight[j][1]);
				resLen = Math.max(resLen, Math.min(rightY - leftY, rightX - leftX));
			}
		}

		return (long) resLen * resLen;

	}


}
