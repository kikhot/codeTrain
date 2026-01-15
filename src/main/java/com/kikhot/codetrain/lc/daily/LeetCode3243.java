package com.kikhot.codetrain.lc.daily;

import java.util.*;

/**
 * @author kikhot
 * @date 2024/11/19
 * @Description 3243. 新增道路查询后的最短距离 I
 * @Difficulty medium
 */
public class LeetCode3243 {

    /**
     * 根据查询计算最短距离
     * 本方法通过广度优先搜索（BFS）算法，针对每个查询计算节点间的最短距离
     *
     * @param n       节点的数量，用于构建初始图
     * @param queries 查询数组，每个查询表示一次图的修改
     * @return 返回一个整数数组，包含每个查询后的最短距离
     */
    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] result = new int[queries.length];
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        for (int i = 0; i < n; i++) {
            neighbors.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            neighbors.get(i).add(i + 1);
        }
        for (int i = 0; i < queries.length; i++) {
            neighbors.get(queries[i][0]).add(queries[i][1]);
            result[i] = bfs(n, neighbors);
        }
        return result;
    }

    /**
     * 使用广度优先搜索算法计算最短距离
     *
     * @param n         节点的数量
     * @param neighbors 邻接表，表示节点的连接关系
     * @return 返回最短距离
     */
    public static int bfs(int n, Map<Integer, List<Integer>> neighbors) {
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        visited[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int visitedNode = queue.poll();
            for (int neighbor : neighbors.get(visitedNode)) {
                if (visited[neighbor] >= 0) {
                    continue;
                }
                queue.add(neighbor);
                visited[neighbor] = visited[visitedNode] + 1;
            }
        }
        return visited[n - 1];
    }


    public static void main(String[] args) {
        int n = 5;
        int[][] queries = {{2, 4}, {0, 2}, {0, 4}};
        int[] result = shortestDistanceAfterQueries(n, queries);

    }

}
