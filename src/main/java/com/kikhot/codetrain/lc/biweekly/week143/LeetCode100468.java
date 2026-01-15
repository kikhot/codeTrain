package com.kikhot.codetrain.lc.biweekly.week143;

/**
 * @author kikhot
 * @date 2024/11/09
 * @Description: 100468. 最小可整除数位乘积 I
 * @result 运行时间： 0 ms / 内存消耗： 39.8 MB
 */
public class LeetCode100468 {
    public int smallestNumber(int n, int t) {
        // 暴力搜索方法，直接解出
        while (true) {
            if (isMultiple(n, t)) {
                return n;
            }
            n++;
        }
    }

    // 将一个数 num 的每一位相乘，得到一个数，判断是否是 t 的倍数，是则返回该数，否则返回 -1
    private boolean isMultiple(int num, int t) {
        int sum = 1;
        while (num > 0) {
            int digit = num % 10;
            sum = sum * digit;
            num /= 10;
        }
        return sum % t == 0;
    }
}
