package com.kikhot.codetrain.lc.biweekly.week143;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author kikhot
 * @date 2024/11/09
 * @Description 100466. 执行操作后元素的最高频率 I
 * @result 94.12MB 击败 100.00%
 */
public class LeetCode100466 {

    public int maxFrequency(int[] nums, int k, int numOperations) {
        // 统计每个 num 的个数，并统计每个 num 增加 [-k, k] 的次数
        HashMap<Integer, Integer> countOriMap = new HashMap<>();    // 未进行 [-k,k] 操作的次数
        Map<Integer, Integer> diff = new TreeMap<>();    // 差分数组
        for (int num : nums) {
            countOriMap.put(num, countOriMap.getOrDefault(num, 0) + 1);
            diff.putIfAbsent(num, 0);
            diff.merge(num - k, 1, Integer::sum);
            diff.merge(num + k + 1, -1, Integer::sum);
        }
        int ans = 0;
        int diffSum = 0;
        // 差分计算，上述已统计每个 num 以及操作之后，每个 num 的频率，按照差分的方法，计算操作后的最高频率
        // 如果 num 本来就在以前的数组中，则 num 的最大频率为 (min(现在的次数, 操作数 + 以前数组的次数))
        for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
            diffSum += entry.getValue();
            ans = Math.max(ans, Math.min(diffSum, numOperations + countOriMap.getOrDefault(entry.getKey(), 0)));
        }
        return ans;
    }
}
