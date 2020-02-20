package com.xd;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int max = 0;
        int prevElement = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max,nums[i] - prevElement);
            prevElement = nums[i];
        }
        return max;
    }
}

