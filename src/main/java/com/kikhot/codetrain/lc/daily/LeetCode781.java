package com.kikhot.codetrain.lc.daily;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Quixote
 * @since 2025-04-20
 */
public class LeetCode781 {

	/**
	 * 计算最少需要多少只兔子
	 *
	 * @param answers 一个整数数组，表示每只兔子看到的其他同色兔子的数量
	 * @return 返回最少需要的兔子数量
	 */
	public int numRabbits(int[] answers) {
	    // 创建一个映射，用于记录每个答案出现的次数
	    Map<Integer, Integer> numMap = new HashMap<>();
	    // 初始化结果变量
	    int result = 0;
	    // 遍历答案数组，统计每个答案出现的次数
	    for (int answer : answers) {
	        numMap.put(answer, numMap.getOrDefault(answer, 0) + 1);
	    }
	    // 遍历映射，计算最少需要的兔子数量
	    for (Integer key : numMap.keySet()) {
	        // 计算每个答案对应的最少兔子数量，并累加到结果变量中
	        result += (int) (Math.ceil((double) numMap.get(key) / (key + 1)) * (key + 1));
	    }
	    // 返回最少需要的兔子数量
	    return result;
	}


}
