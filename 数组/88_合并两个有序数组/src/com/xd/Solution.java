package com.xd;

public class Solution {
    /*
    * nums1 = [1,2,3,0,0,0], m = 3
    * nums2 = [2,5,6],       n = 3
    * [1,2,3,0,5,6]
    * */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1index = m - 1;
        int n2index = n - 1;
        int resultIndex = m + n - 1;
        while (n2index >= 0) {
            if (n1index >= 0 && nums1[n1index] <= nums2[n2index]) {
                nums1[resultIndex--] = nums2[n2index--];
            } else if (n1index >= 0){
                nums1[resultIndex--] = nums1[n1index--];
            } else {
                nums1[resultIndex--] = nums2[n2index--];
            }
        }
    }
}
