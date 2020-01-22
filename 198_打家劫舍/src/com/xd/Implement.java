package com.xd;

public class Implement {

    /*
     * 使用非递归实现，优化空间复杂度
     * */
    public int rob(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int cur = 0;//表示第i - 1
        int prev = 0;//表示第i - 2
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(nums[i] + prev , cur);//比较偷第i个与偷第i - 1个，谁的值更大
            prev = cur;//将i - 1的值 保存到i - 2中
            cur = result;//将i - 1的值更新，以便下次使用
        }
        return result;
    }

    /*
    * 使用非递归实现
    * */
    public int rob3(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        int[] results = new int[nums.length];
        results[0] = nums[0];
        results[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int value1 = nums[i] + results[i - 2];//选择第i家
            int value2 = results[i - 1];//不选择第i家
            results[i] = Math.max(value1,value2);
        }
        return results[nums.length - 1];
    }



    /*
    * 方法二：使用递归实现，从后往前，找出第i项与第i - 1项之间的关系
    * */
    public int rob2(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        return rob2(nums,nums.length - 1);
    }
    public int rob2(int[] nums, int begin){
        if (begin == 0) return nums[begin];
        if (begin == 1) return Math.max(nums[0],nums[begin]);
        int value1 = rob2(nums,begin - 2) + nums[begin]; //选择第begin家
        int value2 = rob2(nums,begin - 1);
        return Math.max(value1,value2);
    }


    /*
    * 方法一：使用递归实现,从前往后,找出第i项与i + 1项之间的关系
    * */
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return rob1(nums,0);
    }

    public int rob1(int[] nums, int begin) {
        if (begin == nums.length - 1) return nums[nums.length - 1];//如果的从最后一个开始，则为最后一个
        if (begin == nums.length - 2) return Math.max(nums[nums.length - 1],nums[nums.length - 2]);
        int value1 = rob1(nums,begin + 2) + nums[begin];//选择第begin家
        int value2 = rob1(nums,begin + 1);//不选择第begin家
        return Math.max(value1,value2);
    }
}
