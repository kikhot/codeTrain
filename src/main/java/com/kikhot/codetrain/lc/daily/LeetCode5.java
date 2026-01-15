package com.kikhot.codetrain.lc.daily;

public class LeetCode5 {

	/**
	 * p(i,j)
	 * i == j p(i,j) = true
	 * i>j p(i,j) = false
	 * i<j-1 p(i,j) = p(i+1,j-1) && s[i]==s[j]
	 * i == j-1 p(i,j) = s[i] == s[j]
	 *
	 * @param s
	 * @return
	 */

	public static String longestPalindrome(String s) {
		int n = s.length();
		if (n < 2) return s;

		int maxLen = 1;
		int begin = 0;
		boolean[][] dp = new boolean[n][n];
		char[] charArray = s.toCharArray();

		// 初始化：所有长度为1的子串是回文
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}

		// 从后往前遍历，确保计算大区间时小区间已处理
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) { // j从i+1开始，避免重复处理单字符
				if (charArray[i] == charArray[j]) {
					// 子串长度≤3时，首尾相等即为回文
					if (j - i <= 2) {
						dp[i][j] = true;
					} else {
						// 状态转移：依赖内部子串
						dp[i][j] = dp[i + 1][j - 1];
					}
				} else {
					dp[i][j] = false;
				}

				// 更新最长回文信息
				if (dp[i][j] && j - i + 1 > maxLen) {
					maxLen = j - i + 1;
					begin = i;
				}
			}
		}
		return s.substring(begin, begin + maxLen);
	}

	public static void main(String[] args) {

	}
}
