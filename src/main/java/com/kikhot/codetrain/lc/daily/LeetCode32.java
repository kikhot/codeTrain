package com.kikhot.codetrain.lc.daily;

import java.util.Collections;
import java.util.Stack;

/**
 * 左右括号匹配，即每个左括号都有对应的右括号将其闭合的字符串是格式正确的，比如 "(()())"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * <p>
 * 输入：s = ""
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 */
public class LeetCode32 {

	public static int longestValidParentheses(String s) {

		Stack<Integer> stack = new Stack<>();   // 左括号位置
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char ch = chars[i];
			if (ch == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty()) {
					// 匹配成功，将左右括号位置标记为空格
					Integer popPosition = stack.pop();
					chars[popPosition] = ' ';
					chars[i] = ' ';
				}
			}
		}

		// 计算最长有效括号子串长度
		int res = 0;
		int maxCount = 0;
		for (char aChar : chars) {
			if (aChar == ' ') {
				maxCount++;
			} else {
				res = Math.max(res, maxCount);
				maxCount = 0;
			}
		}
		return Math.max(res, maxCount);

	}


	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()(()"));
		System.out.println(longestValidParentheses("(()"));
		System.out.println(longestValidParentheses("()(()"));
	}

}
