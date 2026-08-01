package com.kikhot.codetrain.lc.hot100;

import java.util.LinkedList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 * <p>
 * 输入: numRows = 1
 * 输出: [[1]]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= numRows <= 30
 */
public class LC118 {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> resultList = new LinkedList<>();
		List<Integer> lastList = new LinkedList<>();
		lastList.add(1);
		resultList.add(lastList);
		for (int i = 1; i < numRows; i++) {
			List<Integer> thisList = new LinkedList<>();
			thisList.add(1);
			for (int j = 0; j < lastList.size() - 1; j++) {
				thisList.add(lastList.get(j) + lastList.get(j + 1));
			}
			thisList.add(1);
			resultList.add(thisList);
			lastList = thisList;
		}
		return resultList;
	}

}
