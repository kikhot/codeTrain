package com.kikhot.codetrain.lc.daily;

public class LeetCode1732 {

	public int largestAltitude(int[] gain) {
		int res = 0;
		int flag = 0;
		for (int j : gain) {
			flag = flag + j;
			res = Math.max(flag, res);
		}
		return res;
	}

}
