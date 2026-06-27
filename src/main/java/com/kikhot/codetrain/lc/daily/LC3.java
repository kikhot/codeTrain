package com.kikhot.codetrain.lc.daily;

import java.util.HashSet;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class LC3 {

	public static int lengthOfLongestSubstring(String s) {
		int left = 0;
		int res = 0;
		HashSet<Character> set = new HashSet<>();
		for (int right = 0; right < s.length(); right++) {
			char ch = s.charAt(right);
			if (set.contains(ch)) {
				for (int i = left; i < right; i++) {
					left++;
					if (s.charAt(i) != ch) {
						set.remove(s.charAt(i));
					} else {
						break;
					}
				}
			} else {
				set.add(ch);
				res = Math.max(res, right - left + 1);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

}
