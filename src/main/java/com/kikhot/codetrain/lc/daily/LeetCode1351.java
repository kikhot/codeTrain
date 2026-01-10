package com.kikhot.codetrain.lc.daily;

/**
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非严格递减顺序排列。 请你统计并返回 grid 中 负数 的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * 示例 2：
 * <p>
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 */
public class LeetCode1351 {

	public int countNegatives(int[][] grid) {
		// 既然是递减，则直接从后往前找就行了
		int m = grid.length;
		int n = grid[0].length;
		int resCount = 0;

		mContinue:
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (grid[i][j] >= 0) {
					continue mContinue;
				}
				resCount++;
			}
		}

		return resCount;
	}

}
