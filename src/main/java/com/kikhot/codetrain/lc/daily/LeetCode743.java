package com.kikhot.codetrain.lc.daily;

import java.util.Arrays;

/**
 * @author kikhot
 * @date 2024/11/10
 * @Description 540. 有序数组中的单一元素
 * @Difficulty medium
 */
public class LeetCode743 {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n]; // 距离
        final int INF = Integer.MAX_VALUE / 2;
        boolean[] visited = new boolean[n]; // 是否访问过
        Arrays.fill(dist, INF);
        // 计算邻接矩阵
        int[][] weights = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(weights[i], INF);
        }
        for (int i = 0; i < times.length; i++) {
            weights[times[i][0] - 1][times[i][1] - 1] = times[i][2];    // 计算权重
        }
        dist[k - 1] = 0;
        int result = 0;
        while (true) {
            int minIndex = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && (minIndex < 0 || dist[i] < dist[minIndex])) {
                    minIndex = i;
                }
            }
            if (minIndex < 0) {
                return result;
            }
            if (dist[minIndex] == INF) {
                return -1;
            }
            visited[minIndex] = true;
            result = dist[minIndex];
            for (int i = 0; i < n; i++) {
                dist[i] = Math.min(dist[i], dist[minIndex] + weights[minIndex][i]);
            }
        }
    }

}
