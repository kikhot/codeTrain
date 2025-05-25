package com.kikhot.codetrain.lc.daily;

public class LeetCode258 {

	public static int addDigits(int num) {
		while(num / 10 > 0){
			num = sumNums(num);
		}
		return num;
	}

	public static int sumNums(int num){
		int sum = 0;

		while (num > 0) {
			sum += num % 10;
			num /=  10;
		}

		return sum;
	}

	public static void main(String[] args) {
		addDigits(38);
	}

}
