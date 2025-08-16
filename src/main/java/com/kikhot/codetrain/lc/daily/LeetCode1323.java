package com.kikhot.codetrain.lc.daily;

public class LeetCode1323 {

	/**
	 * 将数字中的第一个6转换为9，以获得最大的数字
	 * 从右到左遍历数字的每一位，找到最右边的6（即最高位的6），将其转换为9
	 *
	 * @param num 输入的数字，只包含数字6和9
	 * @return 转换后的最大数字，如果原数字中没有6则返回原数字
	 */
	public int maximum69Number(int num) {
		int oriNum = num;
		int changeFlag = -1;
		int i = 0;
		// 从右到左遍历数字的每一位，记录最右边6的位置
		while (num > 0) {
			if (num % 10 == 6) {
				changeFlag = i;
			}
			num = num / 10;
			i++;
		}
		// 如果找到了6，则将该位置的6转换为9（加上3*10^position）
		if (changeFlag >= 0) {
			return oriNum + (int) Math.pow(10, changeFlag) * 3;
		}
		return oriNum;
	}

}
