package com.kikhot.codetrain.lc.daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 966. 元音拼写检查器
 */
public class LeetCode966 {

	public String[] spellchecker(String[] wordlist, String[] queries) {

		Set<String> matchExactSet = new HashSet<>();
		Map<String, String> wordCaseMap = new HashMap<>();  // 大小写匹配
		Map<String, String> vowelCaseMap = new HashMap<>(); // 元音字符匹配
		for (String word : wordlist) {
			String lowerWord = word.toLowerCase();
			matchExactSet.add(word);
			// 添加大小写匹配集合
			wordCaseMap.putIfAbsent(lowerWord, word);
			// 添加元音字符匹配集合，将元音字符全部用 # 代替
			vowelCaseMap.putIfAbsent(getMatchStr(lowerWord), word);
		}

		String[] result = new String[queries.length];

		for (int i = 0; i < queries.length; i++) {
			String queryStr = queries[i];
			// 1、先查询是否有一模一样的全部匹配的单词
			if (matchExactSet.contains(queryStr)) {
				result[i] = queryStr;
				continue;
			}
			String lowerQueryStr = queryStr.toLowerCase();

			// 2、再判断是否有大小写匹配的单词
			if (wordCaseMap.containsKey(lowerQueryStr)) {
				result[i] = wordCaseMap.get(lowerQueryStr);
				continue;
			}

			// 3、判断元音
			if (vowelCaseMap.containsKey(getMatchStr(lowerQueryStr))) {
				result[i] = vowelCaseMap.get(getMatchStr(lowerQueryStr));
				continue;
			}

			result[i] = "";
		}

		return result;
	}


	private String getMatchStr(String lowerWord) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lowerWord.length(); i++) {
			char ch = lowerWord.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				sb.append("#");
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}
