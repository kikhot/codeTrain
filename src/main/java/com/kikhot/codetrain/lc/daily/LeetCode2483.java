package com.kikhot.codetrain.lc.daily;

import java.beans.PropertyEditorSupport;

/**
 * 给你一个顾客访问商店的日志，用一个下标从 0 开始且只包含字符 'N' 和 'Y' 的字符串 customers 表示：
 * <p>
 * 如果第 i 个字符是 'Y' ，它表示第 i 小时有顾客到达。
 * 如果第 i 个字符是 'N' ，它表示第 i 小时没有顾客到达。
 * 如果商店在第 j 小时关门（0 <= j <= n），代价按如下方式计算：
 * <p>
 * 在开门期间，如果某一个小时没有顾客到达，代价增加 1 。
 * 在关门期间，如果某一个小时有顾客到达，代价增加 1 。
 * 请你返回在确保代价 最小 的前提下，商店的 最早 关门时间。
 * <p>
 * 注意，商店在第 j 小时关门表示在第 j 小时以及之后商店处于关门状态。
 */
public class LeetCode2483 {

	public int bestClosingTime(String customers) {

		int cost = 0;
		// 先遍历商店所有时间都关闭的情况
		for (int i = 0; i < customers.length(); i++) {
			char ch = customers.charAt(i);
			if (ch == 'Y') {
				cost++;
			}
		}

		int resCost = cost;
		int resIndex = -1;

		// 再依次对每个时间开门
		for (int i = 0; i < customers.length(); i++) {
			char ch = customers.charAt(i);
			if (ch == 'Y') {
				cost -= 1;
			} else {
				cost += 1;
			}
			if (cost < resCost) {
				resCost = cost;
				resIndex = i;
			}
		}

		return resIndex + 1;

	}

}
