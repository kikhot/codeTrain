package com.kikhot.codetrain.lc.daily;

import java.util.Arrays;

/**
 * 给定由 n 个小写字母字符串组成的数组 strs ，其中每个字符串长度相等。
 * <p>
 * 选取一个删除索引序列，对于 strs 中的每个字符串，删除对应每个索引处的字符。
 * <p>
 * 比如，有 strs = ["abcdef","uvwxyz"] ，删除索引序列 {0, 2, 3} ，删除后为 ["bef", "vyz"] 。
 * <p>
 * 假设，我们选择了一组删除索引 answer ，那么在执行删除操作之后，最终得到的数组的行中的 每个元素 都是按字典序排列的（即 (strs[0][0] <= strs[0][1] <= ... <= strs[0][strs[0].length - 1]) 和 (strs[1][0] <= strs[1][1] <= ... <= strs[1][strs[1].length - 1]) ，依此类推）。
 * <p>
 * 请返回 answer.length 的最小可能值 。
 */
public class LeetCode960 {

	// 动态规划
	public int minDeletionSize(String[] strs) {
		int strLen = strs[0].length();
		int[] dp = new int[strLen];
		Arrays.fill(dp, 1);
		for (int i = 1; i < strLen; i++) {
			flag:
			for (int j = 0; j < i; j++) {
				for (String str : strs) {
					if (str.charAt(i) < str.charAt(j)) {
						continue flag;
					}
				}
				dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}

		int result = 0;
		for (int i = 0; i < strLen; i++) {
			result = Math.max(result, dp[i]);
		}

		return strLen - result;
	}
}
