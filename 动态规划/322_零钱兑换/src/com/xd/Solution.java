package com.xd;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if ( coins == null || coins.length == 0) return -1;
        //创建一个dp数组，用来保存不同的状态
        int[] dp = new int[amount +1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin :coins) {
                if (i < coin) continue;//如果当前剩余的金额小于当前的面值，就看下一个面值是否符合
                if (dp[i - coin] < 0 /* 这个面值已经计算过，并且值为-1 */|| dp[i - coin] >= min/* 这个面值所需要的的硬币数量大于当前的最小值 */) continue;
                min = dp[i - coin];
            }
            if (min == Integer.MAX_VALUE) {//说明前面的循环，全部都跳过了
                dp[i] = -1;
            } else {//计算出dp[i]时的，所需要的的最大值
                dp[i] = min + 1;
            }
        }
        return dp[amount];
    }
}
