package com.kikhot.codetrain.lc.daily;

public class LeetCode1009 {

	public static int bitwiseComplement(int n) {
		if (n == 0){
			return 1;
		}
		int result = 0;
		int powNum = 1;
		while (n > 0) {
			int div = n % 2;
			n = n / 2;
			if (div == 0) {
				result += powNum;
			}
			powNum = powNum * 2;
		}
		return result;
	}


	public static void main(String[] args) {
		bitwiseComplement(5);
	}
}
