package com.xd;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Implement {
    /*
    * 使用哈希表来保存遍历过的数据
    * */
    public int[] twoSum(int[] nums, int target) {

        /*
        * 例如数组中元素为 [1,5,9,6,4] 其中target为7
        * 得到的差值分别为 [6,2,-2,1,3]
        * 最终，哈希表中存储的数据为{"1":"0","5":"1","9":"2","6":"3","4":"4"}
        * */
        HashMap<Integer,Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {//遍历所有的元素
            //计算当前元素与目标值的差值
            int sub = target - nums[i];
            //判断当前的差值，是否在哈希表中存在 其中，value当前元素的索引，key为当前元素
            //为什么key可以是当前元素，因为如果有两个相同的key，就会使用最新的key，索引就会更新
            //例如在[1,1,9,6,4]，中查找最终结果为10，返回的结果应该为[1,2]，不应该为[0,2]
            if (numMap.containsKey(sub)) {
                //如果存在，就返回当前的索引与保存在哈希表中差值的索引
                return new int[]{numMap.get(sub),i};
            }
            //如果不存在，就将当前的值，保存到哈希表中,将本次遍历到的值，保存到表中，用于后面使用
            if (!numMap.containsKey(nums[i])) {
                numMap.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
    /*
    * 暴力遍历，从第一个元素开始开始匹配
    * */
    public int[] twoSum1(int[] nums, int target) {
        int currentTarget = target;
        int firstIndex = 0;
        int secondIndex = 0;
        while (secondIndex == 0) {
            for (int i = firstIndex; i < nums.length; i++) {
                if (i == firstIndex) {
                    currentTarget = currentTarget - nums[i];
                } else if (nums[i] == currentTarget) {
                    currentTarget = 0;
                    secondIndex = i;
                    break;
                }
            }
            if (secondIndex == 0) {
                currentTarget = target;
                firstIndex++;
            }

        }
        return  new int[]{firstIndex,secondIndex};
    }
}
