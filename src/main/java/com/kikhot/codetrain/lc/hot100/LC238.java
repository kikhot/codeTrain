package com.kikhot.codetrain.lc.hot100;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除了 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 */
public class LC238 {

	public int[] productExceptSelf(int[] nums) {
		int leftP = 1, rightP = 1;
		int left = 0, right = nums.length - 1;
		int[] result = new int[nums.length];
		Arrays.fill(result, 1);
		while (left < nums.length) {
			result[left] *= leftP;
			leftP *= nums[left];
			result[right] *= rightP;
			rightP *= nums[right];
			left++;
			right--;
		}

		return result;
	}

}
