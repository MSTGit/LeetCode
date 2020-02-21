package com.xd;

public class Solution {
    public int[] sortedSquares(int[] A) {
        if (A.length == 0) return new int[]{};
        int[] result = new int[A.length];
        int leftIndex = 0;
        int rightIndex = A.length - 1;
        int curIndex = rightIndex;
        while (leftIndex < rightIndex) {
            int leftValue = Math.abs(A[leftIndex]);
            int rightValue = Math.abs(A[rightIndex]);
            if (leftValue > rightValue) {
                result[curIndex--] = leftValue * leftValue;
                leftIndex++;
            } else {
                result[curIndex--] = rightValue * rightValue;
                rightIndex--;
            }
        }
        return result;
    }
}
