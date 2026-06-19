package com.kikhot.codetrain.lc.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
public class LeetCode1 {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> posMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (posMap.containsKey(target - nums[i])) {
				return new int[]{posMap.get(target - nums[i]), i};
			}
			posMap.put(nums[i], i);
		}
		return new int[]{};
	}

	public static void main(String[] args) {
//		System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
//		System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
//		System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
		System.out.println(Arrays.toString(twoSum(new int[]{2, 5, 5, 11}, 10)));
		System.out.println(Arrays.toString(twoSum(new int[]{0, 4, 3, 0}, 0)));
		System.out.println(Arrays.toString(twoSum(new int[]{-1, -2, -3, -4, -5}, -8)));
	}
}
