package com.kikhot.codetrain.lc.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，返回空字符串 ""。
 * <p>
 * 测试用例保证答案唯一。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 */
public class LC76 {

	public String minWindow(String s, String t) {

		int[] chCnts = new int[125];
		String resStr = null;

		for (char c : t.toCharArray()) {
			chCnts[c]++;
		}

		int[] windowChCnts = new int[125];
		int l = 0;
		for (int r = 0; r < s.length(); r++) {

			windowChCnts[s.charAt(r)]++;

			// 如果找到一个有效的窗口，则将左指针右移，直到窗口失效
			while (isCovered(windowChCnts, chCnts)) {
				resStr = resStr == null || resStr.length() > r + 1 - l ? s.substring(l, r + 1) : resStr;
				windowChCnts[s.charAt(l)]--;
				l++;
			}
		}

		return resStr == null ? "" : resStr;

	}

	private boolean isCovered(int[] cntS, int[] cntT) {
		for (int i = 'A'; i <= 'Z'; i++) {
			if (cntS[i] < cntT[i]) {
				return false;
			}
		}
		for (int i = 'a'; i <= 'z'; i++) {
			if (cntS[i] < cntT[i]) {
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		LC76 lc76 = new LC76();
		System.out.println(lc76.minWindow("ADOBECODEBANC", "ABC"));
	}

}
