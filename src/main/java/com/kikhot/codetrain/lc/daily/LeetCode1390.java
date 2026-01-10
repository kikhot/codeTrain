package com.kikhot.codetrain.lc.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。如果数组中不存在满足题意的整数，则返回 0 。
 */
public class LeetCode1390 {

	public int sumFourDivisors(int[] nums) {
		int totalSum = 0;

		Map<Integer, Integer> divisorSumMap = new HashMap<>(); // 记录表

		for (int num : nums) {
			if (divisorSumMap.containsKey(num)) {
				totalSum += divisorSumMap.get(num);
				continue;
			}

			int divisorSum = getDivisorSum(num);
			if (divisorSum != -1) {
				totalSum += divisorSum;
				divisorSumMap.put(num, divisorSum);
			}
		}

		return totalSum;
	}

	// 获取恰好有4个因数的数字的因数之和,否则返回-1
	private int getDivisorSum(int num) {
		int count = 0;  // 因数个数
		int sum = 0;    // 因数之和

		// 只需遍历到sqrt(num)
		for (int i = 1; i * i <= num; i++) {
			if (num % i == 0) {
				// i 是因数
				count++;
				sum += i;

				// num/i 也是因数(需要判断是否与i相同)
				if (i != num / i) {
					count++;
					sum += num / i;
				}

				// 提前剪枝:如果因数个数已经超过4个,直接返回
				if (count > 4) {
					return -1;
				}
			}
		}

		// 只有恰好4个因数时返回因数和
		return count == 4 ? sum : -1;
	}

}
