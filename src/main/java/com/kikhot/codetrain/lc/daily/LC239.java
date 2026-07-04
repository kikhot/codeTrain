package com.kikhot.codetrain.lc.daily;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239. 滑动窗口最大值
 * <p>
 * <p>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class LC239 {

	public static int[] maxSlidingWindow(int[] nums, int k) {

		Deque<Integer> deque = new ArrayDeque<>();

		int[] result = new int[nums.length - k + 1];

		for (int i = 0; i < nums.length; i++) {
			// 将后面进入的元素与deque中的元素进行比较，如果大于deque中的元素，则将deque中的元素移除
			while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
				deque.pollLast();
			}
			deque.addLast(nums[i]);

			// 如果 i 小于 k，则不删除前面的元素
			if (i < k) {
				if(i==k-1){
					result[0] = deque.peekFirst();
				}
				continue;
			}

			// 大于，则需要处理前面被删除的元素
			if (deque.peekFirst() == nums[i - k]) {
				deque.pollFirst();
			}

			result[i - k + 1] = deque.peekFirst();
		}

		return result;
	}

	public static void main(String[] args) {
		maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
	}

}
