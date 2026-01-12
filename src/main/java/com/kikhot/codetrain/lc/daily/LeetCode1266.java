package com.kikhot.codetrain.lc.daily;

public class LeetCode1266 {

	public int minTimeToVisitAllPoints(int[][] points) {

		int length = points.length;
		int resCount = 0;
		for (int i = 1; i < length; i++) {
			int x = points[i][0];
			int y = points[i][1];
			int preX = points[i - 1][0];
			int preY = points[i - 1][1];

			int xLen = Math.abs(x - preX);
			int yLen = Math.abs(y - preY);

			resCount += Math.max(xLen, yLen);
		}

		return resCount;
	}

}
