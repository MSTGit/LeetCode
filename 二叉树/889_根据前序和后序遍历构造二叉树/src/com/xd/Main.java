package com.xd;

public class Main {
    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};
        new Solution().constructFromPrePost(pre,post);
    }
}
