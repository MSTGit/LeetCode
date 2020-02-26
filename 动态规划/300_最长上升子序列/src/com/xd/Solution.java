package com.xd;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length +1];
        int maxLength = dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);//从前i个中，选出一个最大值
                }
            }
            maxLength = Math.max(dp[i],maxLength);
        }
        return maxLength;
    }
}
