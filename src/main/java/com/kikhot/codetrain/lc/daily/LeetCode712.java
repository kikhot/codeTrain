package com.kikhot.codetrain.lc.daily;

/**
 * 示例 1:
 * <p>
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 * 示例 2:
 * <p>
 * 输入: s1 = "delete", s2 = "leet"
 * 输出: 403
 * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
 * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
 * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
 * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 */
public class LeetCode712 {

	public static int minimumDeleteSum(String s1, String s2) {

		int m = s1.length();
		int n = s2.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		// 获取所有字符串的ASCII值
		int totalASCII = 0;
		for (int i = 0; i < m; i++) {
			totalASCII += s1.charAt(i);
		}
		for (int j = 0; j < n; j++) {
			totalASCII += s2.charAt(j);
		}

		return totalASCII - dp[m][n] * 2;
	}

	public static void main(String[] args) {
		System.out.println(minimumDeleteSum("sea", "eat"));
	}

}
