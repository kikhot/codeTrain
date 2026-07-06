package com.kikhot.codetrain.lc.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[["Q"]]
 */
public class LC5 {


	public List<List<String>> solveNQueens(int n) {

		// 用几个数组存储当前皇后是否跟之前的皇后有冲突
		boolean[] colFlags = new boolean[n];
		// 上对角
		boolean[] diagTop = new boolean[2 * n - 1];
		// 下对角
		boolean[] diagBottom = new boolean[2 * n - 1];
		int[] queens = new int[n];

		List<List<String>> result = new ArrayList<>();
		dfs(0, 0, queens, diagTop, diagBottom, colFlags, result);

		return result;
	}

	private void dfs(int row, int col, int[] queens, boolean[] diagTop, boolean[] diagBottom, boolean[] colFlags, List<List<String>> result) {
		int n = colFlags.length;
		if (row == n) {
			List<String> board = new ArrayList<>();
			for (int r : queens) {
				char[] rows = new char[n];
				Arrays.fill(rows, '.');
				rows[r] = 'Q';
				board.add(new String(rows));
			}
			result.add(board);
			return;
		}

		for (int c = 0; c < n; c++) {
			if (!colFlags[c] && !diagTop[row + c] && !diagBottom[row - c + n - 1]) {
				queens[row] = c;
				colFlags[c] = true;
				diagTop[row + c] = true;
				diagBottom[row - c + n - 1] = true;
				dfs(row + 1, col, queens, diagTop, diagBottom, colFlags, result);
				colFlags[c] = false;
				diagTop[row + c] = false;
				diagBottom[row - c  + n - 1] = false;
			}
		}
	}

	public static void main(String[] args) {
		LC5 lc5 = new LC5();
		System.out.println(lc5.solveNQueens(4));
	}


}
