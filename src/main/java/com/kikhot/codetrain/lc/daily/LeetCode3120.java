package com.kikhot.codetrain.lc.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 word。如果 word 中同时存在某个字母的小写形式和大写形式，则称这个字母为 特殊字母 。
 * <p>
 * 返回 word 中 特殊字母 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：word = "aaAbcBC"
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * word 中的特殊字母是 'a'、'b' 和 'c'。
 * <p>
 * 示例 2:
 * <p>
 * 输入：word = "abc"
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * word 中不存在大小写形式同时出现的字母。
 */
public class LeetCode3120 {

	public int numberOfSpecialChars(String word) {
		Set<Integer> numSet = new HashSet<>();
		Set<Integer> finalSet = new HashSet<>();
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			numSet.add((int) ch);
			if (numSet.contains(ch - 32)) {
				finalSet.add(ch - 32);
				finalSet.add((int) ch);
			}
			if (numSet.contains(ch + 32)) {
				finalSet.add(ch + 32);
				finalSet.add((int) ch);
			}
		}
		return finalSet.size() / 2;
	}

	public static void main(String[] args) {
		System.out.println('b' - 'B');
		System.out.println((int) 'B');
	}
}

