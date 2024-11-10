package com.kikhot.codetrain.lc.daily;

/**
 * @author kikhot
 * @date 2024/11/10
 * @Description 540. 有序数组中的单一元素
 * @Difficulty medium
 * @result 49.05 MB 击败 34.28%
 */
public class LeetCode540 {
    /**
     * 寻找数组中出现次数为1的数字
     * 假设数组中的元素都是成对出现的，除了一个数字只出现了一次
     * 通过二分查找的方式，找到只出现一次的数字
     *
     * @param nums 一个有序数组，除了一个数字出现一次外，其余数字都出现两次
     * @return 返回只出现一次的数字
     */
    public static int singleNonDuplicate(int[] nums) {
        // 如果只有一个，直接返回即可
        if (nums.length == 1) {
            return nums[0];
        }
        // 分情况考虑
        int left = 0;
        int right = nums.length / 2;
        // 左闭右闭
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid * 2] == nums[mid * 2 + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right * 2];
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(singleNonDuplicate(nums));
    }
}
