package com.kikhot.codetrain.lc.daily;

/**
 * 快速幂+MOD取模
 */
public class LeetCode1922 {

	public static final int MOD = 1000000007;

	public int countGoodNumbers(long n) {
		return (int) ((pow(5, (n + 1) / 2) * pow(4, n / 2)) % MOD);
	}

	/**
	 * x^n
	 *
	 * @param x
	 * @param n
	 * @return
	 */
	private long pow(long x, long n) {
		long result = 1;
		while (n > 0) {
			if ((n & 1) > 0) {
				result = result * x % MOD;
			}
			x = x * x % MOD;
			n >>= 1;
		}
		return result;
	}

}
