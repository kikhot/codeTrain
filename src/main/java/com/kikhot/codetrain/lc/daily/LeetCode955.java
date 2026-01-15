package com.kikhot.codetrain.lc.daily;

import java.util.Arrays;

/**
 * 给定由 n 个字符串组成的数组 strs，其中每个字符串长度相等。
 * <p>
 * 选取一个删除索引序列，对于 strs 中的每个字符串，删除对应每个索引处的字符。
 * <p>
 * 比如，有 strs = ["abcdef", "uvwxyz"]，删除索引序列 {0, 2, 3}，删除后 strs 为["bef", "vyz"]。
 * <p>
 * 假设，我们选择了一组删除索引 answer，那么在执行删除操作之后，最终得到的数组的元素是按 字典序（strs[0] <= strs[1] <= strs[2] ... <= strs[n - 1]）排列的，然后请你返回 answer.length 的最小可能值。
 */
public class LeetCode955 {

	public int minDeletionSize(String[] strs) {

		int optCount = 0;
		String[] finalStrs = new String[strs.length];
		Arrays.fill(finalStrs, "");

		next:
		for (int j = 0; j < strs[0].length(); j++) {
			for (int i = 0; i < strs.length - 1; i++) {
				// 当前位置的顺序排序不正确，则需要进行删除操作
				if ((finalStrs[i] + strs[i].charAt(j))
						.compareTo(finalStrs[i + 1] + strs[i + 1].charAt(j)) > 0) {
					optCount++;
					continue next;
				}
			}

			// 升序，记录
			for (int i = 0; i < strs.length; i++) {
				finalStrs[i] += strs[i].charAt(j);
			}

		}

		return optCount;
	}

}
