package com.kikhot.codetrain.lc.hot100;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 * 示例 3：
 * <p>
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现。
 */
public class LC41 {

	public int firstMissingPositive(int[] nums) {
		// 对数组进行遍历，然后对数组里的数重排序，比如 数组数为 1，则将其放在数组下标为 0 的位置
		for (int i = 0; i < nums.length; i++) {
			while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
				int temp2 = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp2;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	public static void main(String[] args) {
		LC41 lc41 = new LC41();
		int[] nums = {3,4,-1,1};
		System.out.println(lc41.firstMissingPositive(nums));
	}
}
