package com.kikhot.codetrain.lc.daily;

import java.util.Arrays;

public class LeetCode3010 {

	public int minimumCost(int[] nums) {
		int firstNum = nums[0];
		Arrays.sort(nums, 1, nums.length);
		return firstNum + nums[1] + nums[2];
	}

}
