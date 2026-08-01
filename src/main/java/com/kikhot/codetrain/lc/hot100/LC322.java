package com.kikhot.codetrain.lc.hot100;

import java.util.Arrays;

/**
 *
 * 代码
 * 测试用例
 * 测试用例
 * 测试结果
 * 322. 零钱兑换
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 */
public class LC322 {

	public int coinChange(int[] coins, int amount) {

		int[] dp = new int[amount + 1];
		Arrays.sort(coins);
		for (int i = 1; i < amount + 1; i++) {
			dp[i] = Integer.MAX_VALUE / 2;
			for (int coin : coins) {
				if (coin > i) break;
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}

		return dp[amount] >= Integer.MAX_VALUE / 2 ? -1 : dp[amount];

	}


	public static void main(String[] args) {
		LC322 lc322 = new LC322();
		int[] coins = {2};
		int amount = 3;
		int i = lc322.coinChange(coins, amount);
		System.out.println(i);
	}

}
