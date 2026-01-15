package com.kikhot.codetrain.lc.daily;

import java.util.Arrays;

/**
 * 给你一个整数 n ，共有编号从 0 到 n - 1 的 n 个会议室。
 * <p>
 * 给你一个二维整数数组 meetings ，其中 meetings[i] = [starti, endi] 表示一场会议将会在 半闭 时间区间 [starti, endi) 举办。所有 starti 的值 互不相同 。
 * <p>
 * 会议将会按以下方式分配给会议室：
 * <p>
 * 每场会议都会在未占用且编号 最小 的会议室举办。
 * 如果没有可用的会议室，会议将会延期，直到存在空闲的会议室。延期会议的持续时间和原会议持续时间 相同 。
 * 当会议室处于未占用状态时，将会优先提供给原 开始 时间更早的会议。
 * 返回举办最多次会议的房间 编号 。如果存在多个房间满足此条件，则返回编号 最小 的房间。
 * <p>
 * 半闭区间 [a, b) 是 a 和 b 之间的区间，包括 a 但 不包括 b 。
 */
public class LeetCode2402 {

	public static int mostBooked(int n, int[][] meetings) {
		// 正序排序数组
		Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
		long[] untilUsedMeetTime = new long[n];
		int[] useMeetCount = new int[n];

		meetingContinue:
		for (int i = 0; i < meetings.length; i++) {
			// 开始时间
			int startTime = meetings[i][0];
			// 结束时间
			int endTime = meetings[i][1];

			// 获取最前面最早空闲的会议室
			int findMinIndex = 0;
			for (int j = 0; j < n; j++) {
				// 如果会议开始时间大于等于当前会议占用时间，则直接使用当前会议
				if (untilUsedMeetTime[j] <= startTime) {
					untilUsedMeetTime[j] = endTime;
					useMeetCount[j]++;
					continue meetingContinue;
				}
				if (untilUsedMeetTime[j] < untilUsedMeetTime[findMinIndex]) {
					findMinIndex = j;
				}
			}

			// 获取会议时间
			long needMeetTime = endTime - startTime;
			untilUsedMeetTime[findMinIndex] += needMeetTime;
			useMeetCount[findMinIndex]++;

		}

		// 最终次数最大的会议室
		int index = 0;
		for (int i = 1; i < n; i++) {
			if (useMeetCount[index] < useMeetCount[i]) {
				index = i;
			}
		}

		return index;

	}


	public static void main(String[] args) {
		mostBooked(3, new int[][] {
				{1, 20},
				{2, 10},
				{3, 5},
				{4, 9},
				{6, 8}
		});
	}
}
