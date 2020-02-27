package com.xd;

public class Solution {
    //内存优化
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int dp = max;
        for (int i = 0; i < nums.length; i++) {
            if (dp <= 0) {
                dp = nums[i];
            } else {
                dp += nums[i];
            }
            max = Math.max(max,dp);
        }
        return max;
    }
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length +1];
        int max = dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int prev = dp[i - 1];//找到上一个元素的最大子序和
            if (prev <= 0) {//如果上一个元素的最大子序和为小于0，那么加上当前的元素，值会更小，当前dp[i]的最大值就位当前元素的值
                dp[i] = nums[i];
            } else {//否则就将当前元素的值与上一个元素的最大子序和相加
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(max,dp[i]);//保存当前值最大的一个
        }
        return max;
    }
}
