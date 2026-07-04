package com.kikhot.codetrain.lc.daily;


import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * <p>
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 子数组是数组中元素的连续非空序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class LC560 {

	public static int subarraySum(int[] nums, int k) {
		int[] preSums = new int[nums.length + 1];
		Map<Integer, Integer> sumCountMap = new HashMap();
		preSums[0] = 0;
		sumCountMap.put(0, 1);
		int resCount = 0;
		for (int i = 1; i < nums.length + 1; i++) {

			preSums[i] = preSums[i - 1] + nums[i - 1];

			int subSum = preSums[i] - k;
			if (sumCountMap.containsKey(subSum)) {
				resCount += sumCountMap.get(subSum);
			}

			sumCountMap.merge(preSums[i], 1, Integer::sum);
		}

		return resCount;

	}

	public static void main(String[] args) {
		subarraySum(new int[]{-1,-1,1}, 0);
	}

}
