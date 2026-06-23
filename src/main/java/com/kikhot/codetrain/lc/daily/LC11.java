package com.kikhot.codetrain.lc.daily;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class LC11 {

	public int maxArea(int[] height) {
		// 双指针
		int fPoint = 0;
		int lPoint = height.length - 1;
		int res = 0;
		while (fPoint < lPoint) {
			res = Math.max(res, Math.min(height[fPoint], height[lPoint]) * (lPoint - fPoint));
			if (height[fPoint] < height[lPoint]) {
				fPoint++;
			} else {
				lPoint--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		LC11 lc11 = new LC11();
		int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		System.out.println(lc11.maxArea(height));
	}
}
