package com.xd;

public class Solution {
    public int[] subSort(int[] array) {
        if (array.length == 0) return new int[]{-1,-1};
        int leftIndex = -1;
        int rightIndex = -1;
        int curIndex = 0;
        int leftMax = array[0];
        int rightMin = array[array.length - 1];
        //从左往右找右边的索引
        //找到左边的最大值,第一个大于最大值的索引,就是要找的索引
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= leftMax) {
                leftMax = array[i];//更新最大值
            } else {
                rightIndex = i;
            }
        }

        //从右往左找左边的索引
        //找到右边的最小值,第一个大于最小值的索引,就是要找的索引
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] <= rightMin) {
                rightMin = array[i];//更新最大值
            } else {
                leftIndex = i;
            }
        }
        return new int[]{leftIndex,rightIndex};
    }
}
