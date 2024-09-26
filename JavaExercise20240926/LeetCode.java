package com.wzb.JavaExercise20240926;

public class LeetCode {
    //    给你一个正整数数组 nums 。
//    元素和 是 nums 中的所有元素相加求和。
//    数字和 是 nums 中每一个元素的每一数位（重复数位需多次求和）相加求和。
//    返回 元素和 与 数字和 的绝对差。
//    注意：两个整数 x 和 y 的绝对差定义为 |x - y| 。
    public static void main(String[] args) {
        int[] array = {1, 15, 6, 3};
        Solution solution = new Solution();
        System.out.println(solution.differenceOfSum(array));
    }

}


class Solution {
    public int differenceOfSum(int[] nums) {
        int elementSum = 0;
        int numberSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            elementSum += temp;
            while (temp > 0) {
                numberSum += (temp % 10);
                temp /= 10;
            }
        }
        return Math.abs(elementSum - numberSum);
    }
}
