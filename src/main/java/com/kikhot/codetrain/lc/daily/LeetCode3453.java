package com.kikhot.codetrain.lc.daily;

/**
 * 给你一个二维整数数组 squares ，其中 squares[i] = [xi, yi, li] 表示一个与 x 轴平行的正方形的左下角坐标和正方形的边长。
 * <p>
 * 找到一个最小的 y 坐标，它对应一条水平线，该线需要满足它以上正方形的总面积 等于 该线以下正方形的总面积。
 * <p>
 * 答案如果与实际答案的误差在 10-5 以内，将视为正确答案。
 * <p>
 * 注意：正方形 可能会 重叠。重叠区域应该被 多次计数 。
 */
public class LeetCode3453 {
	private int[][] squares;
	private double s;

	private boolean check(double y1) {
		double t = 0.0;
		for (int[] a : squares) {
			int y = a[1];
			int l = a[2];
			if (y < y1) {
				t += (double) l * Math.min(y1 - y, l);
			}
		}
		return t >= s / 2.0;
	}

	public double separateSquares(int[][] squares) {
		this.squares = squares;
		s = 0.0;
		double l = 0.0;
		double r = 0.0;
		for (int[] a : squares) {
			s += (double) a[2] * a[2];
			r = Math.max(r, a[1] + a[2]);
		}

		double eps = 1e-5;
		while (r - l > eps) {
			double mid = (l + r) / 2.0;
			if (check(mid)) {
				r = mid;
			} else {
				l = mid;
			}
		}
		return r;
	}
}
