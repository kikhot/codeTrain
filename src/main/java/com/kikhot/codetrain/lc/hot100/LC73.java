package com.kikhot.codetrain.lc.hot100;

import java.util.Arrays;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
public class LC73 {

	public void setZeroes(int[][] matrix) {

		int m = matrix.length;
		int n = matrix[0].length;

		boolean firstRowHasZero = false;
		for (int j = 0; j < n; j++) {
			if (matrix[0][j] == 0) {
				firstRowHasZero = true;
				break;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) { // 如果第一列包含 0，那么 matrix[0][0] 会置为 0
				if (matrix[i][j] == 0) {
					matrix[i][0] = matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// 注意顺序，先改第一列，再改第一行（避免把 matrix[0][0] 从 1 改成 0 影响判断）
		if (matrix[0][0] == 0) { // 替换原来的 firstColHasZero
			for (int[] row : matrix) {
				row[0] = 0;
			}
		}

		if (firstRowHasZero) {
			Arrays.fill(matrix[0], 0);
		}

	}
}
