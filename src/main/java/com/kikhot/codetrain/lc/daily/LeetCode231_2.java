package com.kikhot.codetrain.lc.daily;


/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 */
public class LeetCode231_2 {


	public boolean isPowerOfTwo(int n) {
		// 首先判断 1
		if (n == 1) {
			return true;
		}
		// 判断 0
		if (n <= 0) {
			return false;
		}
		//然后循环判断是否是偶数
		while (n > 1) {
			if (n % 2 != 0) {
				return false;
			}
			n = n / 2;
		}

		return true;
	}
}
