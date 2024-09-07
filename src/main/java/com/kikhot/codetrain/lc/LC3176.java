package com.kikhot.codetrain.lc;

import java.util.Arrays;

public class LC3176 {
    /**
     * dp 转换公式
     * <p>
     * dp[i][j] =
     * max(dp[i][j], dp[p][j] + 1), dp[i] = dp[p]      p in [0, i-1]
     * max(dp[i][j], dp[p][j-1] + 1), dp[i] != dp[p]
     */
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[nums.length][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 1);
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= k; j++) {
                for (int p = 0; p <= i - 1; p++) {
                    if (nums[i] == nums[p]) {
                        dp[i][j] = Math.max(dp[i][j], dp[p][j] + 1);
                    } else if (j > 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[p][j - 1] + 1);
                    }
                }
                result = Math.max(dp[i][j], result);
            }
        }
        return result;
    }
}
