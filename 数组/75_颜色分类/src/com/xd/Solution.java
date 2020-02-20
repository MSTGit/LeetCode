package com.xd;

public class Solution {
    public void sortColors(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int curIndex = 0;
        while (rightIndex >= curIndex) {
            if (nums[curIndex] == 2) {
                swip(nums,rightIndex--,curIndex);//如果是2的时候,将当前位置的元素换到左边以后,当前的指针先不往右移动,因为当前移动过去的元素也是2,当前指针向右移动以后就失去了一次比较的机会
            } else if (nums[curIndex] == 0) {
                swip(nums,leftIndex++,curIndex++);
            } else {
                curIndex++;
            }
        }
    }
    void swip(int[] nums,int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}

class Solution1 {
    public void sortColors(int[] nums) {
        int n0Count = 0;
        int n1Count = 0;
        int n2Count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                n0Count++;
            } else if (nums[i] == 1) {
                n1Count++;
            } else {
                n2Count++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < n0Count) {
                nums[i] = 0;
            } else if (i < (n0Count + n1Count)) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
