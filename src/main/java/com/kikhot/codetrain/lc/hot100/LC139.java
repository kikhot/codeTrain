package com.kikhot.codetrain.lc.hot100;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class LC139 {

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordSet = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		int maxLen = 0;
		for (String word : wordSet) {
			maxLen = Math.max(maxLen, word.length());
		}

		dp[0] = true;

		for (int i = 0; i <= s.length(); i++) {
			for (int j = i - 1; j >= Math.max(0, i - maxLen); j--) {
				if (dp[j] && wordSet.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

}
