package com.kikhot.codetrain.lc.daily;

public class LeetCode3206 {

    /**
     * 计算数组中交替颜色的组数
     * 本方法旨在统计给定颜色数组中，连续交替的颜色组数，但只统计交替次数达到或超过3次的组
     *
     * @param colors 表示颜色的整数数组，数组中的每个元素代表一种颜色
     * @return 返回满足条件的交替颜色组的数量
     */
    public int numberOfAlternatingGroups(int[] colors) {
        int flag = 0;   // 记录连续交替的个数
        int result = 0;
        // 循环遍历颜色数组，额外增加2个单位长度以处理边界情况
        for (int i = 0; i < colors.length + 2; i++) {
            // 使用取余操作以安全地访问数组元素，避免数组越界
            // 检查当前元素是否与前一个元素不同，以判断是否为交替颜色
            if (i == 0 || colors[i % colors.length] != colors[(i - 1) % colors.length]) {
                flag++;
                // 当交替次数达到或超过3次时，增加结果计数
                if (flag >= 3) {
                    result++;
                }
            } else {
                // 如果当前元素与前一个元素相同，重置交替计数
                flag = 1;
            }
        }
        // 返回交替颜色组的数量
        return result;
    }

    // 单元测试
    public static void main(String[] args) {
        LeetCode3206 leetCode3206 = new LeetCode3206();
        int[] colors = {1,1,1};
        System.out.println(leetCode3206.numberOfAlternatingGroups(colors));
    }
}
